package com.nomadit.api.portfolio.interfaces.web.controllers;

import com.nomadit.api.portfolio.application.services.ProjetoService;
import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.interfaces.web.dto.ProjetoDTO;
import com.nomadit.api.portfolio.interfaces.web.mappers.DataMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;
    private final DataMappers dataMappers;

    @Autowired
    public ProjetoController(ProjetoService projetoService, DataMappers dataMappers) {
        this.projetoService = projetoService;
        this.dataMappers = dataMappers;
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> criarProjeto(@RequestBody ProjetoDTO projeto) {
        ProjetoDTO novoProjeto =
            Optional.of(projetoService.criarProjeto(dataMappers.projetoToDTO(projeto)))
                .map(dataMappers::dtoToProjeto)
                .orElseThrow();
        return new ResponseEntity<>(novoProjeto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> obterProjetoPorId(@PathVariable Long id) {
        ProjetoDTO projeto =
            Optional.of(projetoService.obterProjetoPorId(id))
                .map(dataMappers::dtoToProjeto)
                .orElseThrow();
        return ResponseEntity.ok(projeto);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> obterTodosProjetos() {
        List<ProjetoDTO> projetos = projetoService.listarProjetos()
                .stream()
                .map(dataMappers::dtoToProjeto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projetos);
    }

    @PostMapping("/obterTodos")
    public ResponseEntity<List<ProjetoDTO>> obterTodosProjetos(@RequestBody ProjetoDTO projeto,
                                                               @RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size) {
        List<ProjetoDTO> projetos = projetoService.listarProjetos(dataMappers.projetoToDTO(projeto), page, size)
                .stream()
                .map(dataMappers::dtoToProjeto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projetos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDTO> atualizarProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        ProjetoDTO projetoAtualizado =
                Optional.of(projetoService.atualizarProjeto(id, projeto))
                        .map(dataMappers::dtoToProjeto)
                        .orElseThrow();
        return ResponseEntity.ok(projetoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProjeto(@PathVariable Long id) {
        projetoService.excluirProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
