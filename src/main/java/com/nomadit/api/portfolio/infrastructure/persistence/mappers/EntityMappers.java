package com.nomadit.api.portfolio.infrastructure.persistence.mappers;

import com.nomadit.api.portfolio.domain.model.Membro;
import com.nomadit.api.portfolio.domain.model.Pessoa;
import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.MembrosEntity;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.PessoaEntity;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.ProjetoEntity;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.enums.RiscoEnum;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.enums.StatusEnum;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.ZoneId;

@Component
public class EntityMappers {
    public Projeto projectEntityToProjeto(ProjetoEntity projetoEntity) {
        return Projeto.builder()
                .id(projetoEntity.getId())
                .dataFim(Date.from(projetoEntity.getDataFim().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .nome(projetoEntity.getNome())
                .risco(projetoEntity.getRisco().getDescricao())
                .orcamento(projetoEntity.getOrcamento())
                .status(projetoEntity.getStatus().getDescricao())
                .dataInicio(Date.from(projetoEntity.getDataInicio().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .dataPrevisaoFim(Date.from(projetoEntity.getDataPrevisaoFim().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .gerente(pessoaEntityToPessoa(projetoEntity.getGerente()))
                .build();
    }

    public ProjetoEntity projectToProjetoEntity(Projeto projeto) {
        return ProjetoEntity.builder()
                .id(projeto.getId())
                .dataFim(projeto.getDataFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .nome(projeto.getNome())
                .risco(RiscoEnum.valueOf(projeto.getRisco()))
                .orcamento(projeto.getOrcamento())
                .status(StatusEnum.valueOf(projeto.getStatus()))
                .dataInicio(projeto.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .dataPrevisaoFim(projeto.getDataPrevisaoFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .gerente(pessoaToPessoaEntity(projeto.getGerente()))
                .build();
    }

    public Pessoa pessoaEntityToPessoa(PessoaEntity pessoaEntity) {
        return Pessoa.builder()
                .id(pessoaEntity.getId())
                .cpf(pessoaEntity.getCpf())
                .nome(pessoaEntity.getNome())
                .dataNascimento(Date.from(pessoaEntity.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .funcionario(pessoaEntity.isFuncionario())
                .build();
    }

    public PessoaEntity pessoaToPessoaEntity(Pessoa pessoa) {
        return PessoaEntity.builder()
                .id(pessoa.getId())
                .cpf(pessoa.getCpf())
                .nome(pessoa.getNome())
                .dataNascimento(pessoa.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .funcionario(pessoa.isFuncionario())
                .build();
    }

    public MembrosEntity membroToMembroEntity(Membro membro) {
        return MembrosEntity.builder()
//                .pessoa(pessoaToPessoaEntity(membro.getPessoa()))
//                .projeto(projectToProjetoEntity(membro.getProjeto()))
                .build();
    }

    public Membro membroEntityToMembro(MembrosEntity membro) {
        return Membro.builder()
//                .pessoa(pessoaToPessoaEntity(membro.getPessoa()))
//                .projeto(projectToProjetoEntity(membro.getProjeto()))
                .build();
    }
}
