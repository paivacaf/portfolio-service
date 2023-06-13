package com.nomadit.api.portfolio.infrastructure.persistence.entities;

import com.nomadit.api.portfolio.infrastructure.persistence.entities.converters.RiscoEnumConverter;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.converters.StatusEnumConverter;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.enums.RiscoEnum;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "projeto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_previsao_fim")
    private LocalDate dataPrevisaoFim;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "descricao", length = 5000)
    private String descricao;

    @Column(name = "status", length = 45)
    @Convert(converter = StatusEnumConverter.class)
    private StatusEnum status;

    @Column(name = "orcamento")
    private Float orcamento;

    @Column(name = "risco", length = 45)
    @Convert(converter = RiscoEnumConverter.class)
    private RiscoEnum risco;

    @ManyToOne
    @JoinColumn(name = "idgerente", referencedColumnName = "id", nullable = false)
    private PessoaEntity gerente;

}
