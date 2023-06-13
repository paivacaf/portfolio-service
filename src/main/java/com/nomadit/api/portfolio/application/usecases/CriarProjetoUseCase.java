package com.nomadit.api.portfolio.application.usecases;


import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public Projeto executar(Projeto projeto) {
        projetoRepository.salvar(projeto);
        return projeto;
    }
}
