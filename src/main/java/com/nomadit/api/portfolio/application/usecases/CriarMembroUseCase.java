package com.nomadit.api.portfolio.application.usecases;

import com.nomadit.api.portfolio.domain.model.Membro;
import com.nomadit.api.portfolio.domain.repositories.MembroRepository;
import com.nomadit.api.portfolio.shared.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CriarMembroUseCase {

    private final MembroRepository membroRepository;

    public Membro executar(Membro membro) {
        return membroRepository.criarMembro(membro);
    }
}
