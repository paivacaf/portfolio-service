package com.nomadit.api.portfolio.application.usecases;


import com.nomadit.api.portfolio.application.exceptions.RegraDeNegocioNaoAtendidaException;
import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.enums.StatusEnum;
import com.nomadit.api.portfolio.shared.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ExcluirProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public void executar(Long projetoId) {
        Projeto projeto = projetoRepository.obterPorId(projetoId);
        if (StatusEnum.INICIADO.equals(projeto.getStatus())
                || StatusEnum.EM_ANDAMENTO.equals(projeto.getStatus())
                || StatusEnum.ENCERRADO.equals(projeto.getStatus())) {
            throw new RegraDeNegocioNaoAtendidaException("Projeto com status " + projeto.getStatus() + " não pode ser mais excluído.");
        }
        projetoRepository.excluirPorId(projetoId);
    }
}
