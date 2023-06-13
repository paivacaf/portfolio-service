package com.nomadit.api.portfolio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private boolean funcionario;
}
