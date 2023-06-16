package com.nomadit.api.portfolio.interfaces.web.controllers;

import com.nomadit.api.portfolio.application.services.ProjetoService;
import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.interfaces.web.dto.ProjetoDTO;
import com.nomadit.api.portfolio.interfaces.web.mappers.DTOMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;
    private final DTOMappers dtoMappers;

    /**
     *
     * @param projeto
     * @return
     */
    @PostMapping
    public ResponseEntity<ProjetoDTO> criarProjeto(@RequestBody ProjetoDTO projeto) {
        return new ResponseEntity<>(Optional.of(projeto)
                                        .map(dtoMappers::projetoToDTO)
                                        .map(projetoService::criarProjeto)
                                        .map(dtoMappers::dtoToProjeto)
                                    .orElseThrow(), HttpStatus.CREATED);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> obterProjetoPorId(@PathVariable Long id) {
        return ResponseEntity
                .ok(Optional.of(id)
                        .map(projetoService::obterProjetoPorId)
                        .map(dtoMappers::dtoToProjeto)
                        .orElseThrow());
    }

    /**
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> obterTodosProjetos() {
        return ResponseEntity.ok(projetoService.listarProjetos().stream()
                .map(dtoMappers::dtoToProjeto)
                .collect(Collectors.toList()));
    }

    /**
     *
     * @param projetoDTO
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/obterTodos")
    public ResponseEntity<List<ProjetoDTO>> obterTodosProjetos(@RequestBody ProjetoDTO projetoDTO,
                                                               @RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size) {
        Projeto projeto = Optional.of(projetoDTO)
                .map(dtoMappers::projetoToDTO).orElseThrow();

        List<ProjetoDTO> projetos = projetoService.listarProjetos(projeto, page, size).stream()
                 .map(dtoMappers::dtoToProjeto).collect(Collectors.toList());

        return ResponseEntity.ok(projetos);
    }

    /**
     *
     * @param projeto
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDTO> atualizarProjeto(@RequestBody ProjetoDTO projeto) {
        return ResponseEntity.ok(
                    Optional.of(projeto)
                            .map(dtoMappers::projetoToDTO)
                            .map(projetoService::atualizarProjeto)
                            .map(dtoMappers::dtoToProjeto)
                        .orElseThrow());
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProjeto(@PathVariable Long id) {
        projetoService.excluirProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
