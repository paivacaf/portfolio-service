package com.nomadit.api.portfolio.application.usecases;

import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AtualizarProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public Projeto executar(Long id, Projeto projeto) {
        Optional.of(projetoRepository.obterPorId(id))
                .orElseThrow();
        projetoRepository.salvar(projeto);
        return projeto;
    }
}
