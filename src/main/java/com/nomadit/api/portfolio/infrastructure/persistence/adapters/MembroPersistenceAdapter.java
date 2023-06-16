package com.nomadit.api.portfolio.infrastructure.persistence.adapters;

import com.nomadit.api.portfolio.domain.model.Membro;
import com.nomadit.api.portfolio.domain.repositories.MembroRepository;
import com.nomadit.api.portfolio.infrastructure.persistence.mappers.EntityMappers;
import com.nomadit.api.portfolio.infrastructure.persistence.repositories.MembroJpaRepository;
import com.nomadit.api.portfolio.shared.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembroPersistenceAdapter implements MembroRepository {

    private final MembroJpaRepository membroJpaRepository;
    private final EntityMappers entityMappers;

    @Override
    public Membro criarMembro(Membro membro) {
        return Optional.of(membro)
            .map(entityMappers::membroToMembroEntity)
            .map(membroJpaRepository::save)
            .map(entityMappers::membroEntityToMembro)
            .orElseThrow();
    }
}
