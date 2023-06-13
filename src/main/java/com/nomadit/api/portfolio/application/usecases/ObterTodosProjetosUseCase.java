package com.nomadit.api.portfolio.application.usecases;


import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import com.nomadit.api.portfolio.interfaces.web.dto.ProjetoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class ObterTodosProjetosUseCase {

    private final ProjetoRepository projetoRepository;

    public List<Projeto> executar() {
        return projetoRepository.obterTodos();
    }

    public List<Projeto> executar(Projeto projeto, int page, int size) {
        return projetoRepository.obterTodos(projeto, page, size);
    }
}
