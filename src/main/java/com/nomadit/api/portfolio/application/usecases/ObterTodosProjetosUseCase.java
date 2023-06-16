package com.nomadit.api.portfolio.application.usecases;


import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import com.nomadit.api.portfolio.shared.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
@UseCase
@RequiredArgsConstructor
public class ObterTodosProjetosUseCase {

    private final ProjetoRepository projetoRepository;

    public List<Projeto> executar() {
        return projetoRepository.listarProjetos();
    }

    public List<Projeto> executar(Projeto projeto, int page, int size) {
        return projetoRepository.pesquisarProjetos(projeto, page, size);
    }
}
