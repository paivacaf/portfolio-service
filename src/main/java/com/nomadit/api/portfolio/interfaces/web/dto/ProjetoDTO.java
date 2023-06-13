package com.nomadit.api.portfolio.interfaces.web.dto;

import com.nomadit.api.portfolio.domain.model.Pessoa;
import lombok.*;

import java.util.Date;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {
    private Long id;
    private String nome;
    private Date dataInicio;
    private Date dataPrevisaoFim;
    private Date dataFim;
    private String descricao;
    private String status;
    private float orcamento;
    private String risco;
    private Pessoa gerente;
}
