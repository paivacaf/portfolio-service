package com.nomadit.api.portfolio.infrastructure.persistence.adapters;

import com.nomadit.api.portfolio.domain.model.Pessoa;
import com.nomadit.api.portfolio.domain.repositories.PessoaRepository;
import com.nomadit.api.portfolio.infrastructure.persistence.mappers.EntityMappers;
import com.nomadit.api.portfolio.infrastructure.persistence.repositories.PessoaJpaRepository;
import com.nomadit.api.portfolio.shared.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class PessoaPersistenceAdapter implements PessoaRepository {

    private final PessoaJpaRepository pessoaJpaRepository;
    private final EntityMappers entityMappers;

    @Override
    public Pessoa criarPessoa(Pessoa pessoa) {
        return Optional.of(pessoa)
                .map(entityMappers::pessoaToPessoaEntity)
                .map(pessoaJpaRepository::save)
                .map(entityMappers::pessoaEntityToPessoa)
                .orElseThrow();
    }
}
