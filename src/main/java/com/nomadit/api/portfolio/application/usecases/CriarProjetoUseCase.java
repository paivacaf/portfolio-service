package com.nomadit.api.portfolio.application.usecases;


import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import com.nomadit.api.portfolio.shared.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CriarProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public Projeto executar(Projeto projeto) {
        return projetoRepository.criarProjeto(projeto);
    }
}
