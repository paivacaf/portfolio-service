package com.nomadit.api.portfolio.application.usecases;


import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExcluirProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public void executar(Long projetoId) {
        projetoRepository.excluirPorId(projetoId);
    }
}
