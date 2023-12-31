package com.nomadit.api.portfolio.application.services;

import com.nomadit.api.portfolio.application.usecases.*;
import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.interfaces.web.dto.ProjetoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final CriarProjetoUseCase criarProjetoUseCase;
    private final AtualizarProjetoUseCase atualizarProjetoUseCase;
    private final ExcluirProjetoUseCase excluirProjetoUseCase;
    private final ObterProjetoPorIdUseCase obterProjetoPorIdUseCase;
    private final ObterTodosProjetosUseCase obterTodosProjetosUseCase;

    public Projeto criarProjeto(Projeto projeto) {
        return criarProjetoUseCase.executar(projeto);
    }
    public void excluirProjeto(Long id) {
        excluirProjetoUseCase.executar(id);
    }
    public Projeto obterProjetoPorId(Long id) {
        return obterProjetoPorIdUseCase.executar(id);
    }

    public List<Projeto> obterTodosProjetos() {
        return obterTodosProjetosUseCase.executar();
    }
    public List<Projeto> obterTodosProjetos(Projeto projeto, int page, int size) {
        return obterTodosProjetosUseCase.executar(projeto, page, size);
    }
    public Projeto atualizarProjeto(Long id, Projeto projeto) {
        return atualizarProjetoUseCase.executar(id, projeto);
    }
}
