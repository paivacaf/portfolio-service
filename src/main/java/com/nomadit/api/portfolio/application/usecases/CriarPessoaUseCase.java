package com.nomadit.api.portfolio.application.usecases;

import com.nomadit.api.portfolio.domain.model.Pessoa;
import com.nomadit.api.portfolio.domain.repositories.PessoaRepository;
import com.nomadit.api.portfolio.shared.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CriarPessoaUseCase {

    private final PessoaRepository pessoaRepository;

    public Pessoa executar(Pessoa pessoa) {
        return pessoaRepository.criarPessoa(pessoa);
    }

}
