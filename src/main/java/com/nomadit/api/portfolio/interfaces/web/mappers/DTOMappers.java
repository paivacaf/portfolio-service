package com.nomadit.api.portfolio.interfaces.web.mappers;

import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.interfaces.web.dto.ProjetoDTO;
import org.springframework.stereotype.Component;

@Component
public class DTOMappers {
    public Projeto projetoToDTO(ProjetoDTO projeto) {
        return Projeto.builder()
                .id(projeto.getId())
                .nome(projeto.getNome())
                .dataPrevisaoFim(projeto.getDataPrevisaoFim())
                .dataFim(projeto.getDataFim())
                .dataInicio(projeto.getDataInicio())
                .risco(projeto.getRisco())
                .status(projeto.getStatus())
                .orcamento(projeto.getOrcamento())
                .gerente(projeto.getGerente())
                .descricao(projeto.getDescricao())
                .build();
    }

    public ProjetoDTO dtoToProjeto(Projeto projeto) {
        return ProjetoDTO.builder()
                .id(projeto.getId())
                .dataFim(projeto.getDataFim())
                .dataInicio(projeto.getDataInicio())
                .dataPrevisaoFim(projeto.getDataPrevisaoFim())
                .descricao(projeto.getDescricao())
                .status(projeto.getStatus())
                .orcamento(projeto.getOrcamento())
                .gerente(projeto.getGerente())
                .build();
    }
}
