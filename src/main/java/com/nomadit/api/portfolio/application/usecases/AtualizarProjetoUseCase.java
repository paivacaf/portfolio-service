package com.nomadit.api.portfolio.application.usecases;

import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import com.nomadit.api.portfolio.shared.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class AtualizarProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public Projeto executar(Projeto projeto) {
        return Optional.of(projetoRepository.obterPorId(projeto.getId()))
                .map(projetoRepository::criarProjeto)
                .orElseThrow();
    }
}
