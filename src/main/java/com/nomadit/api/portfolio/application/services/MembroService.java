package com.nomadit.api.portfolio.application.services;

import com.nomadit.api.portfolio.application.usecases.CriarMembroUseCase;
import com.nomadit.api.portfolio.application.usecases.CriarPessoaUseCase;
import com.nomadit.api.portfolio.domain.model.Membro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final CriarMembroUseCase criarMembroUseCase;
    private final CriarPessoaUseCase criarPessoaUseCase;

    public Membro criarMembro(Membro membro) {
        return criarMembroUseCase.executar(membro);
    }
}
