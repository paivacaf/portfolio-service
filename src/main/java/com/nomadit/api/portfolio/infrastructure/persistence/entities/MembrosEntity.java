package com.nomadit.api.portfolio.infrastructure.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "membros")
public class MembrosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idprojeto", referencedColumnName = "id", nullable = false)
    private ProjetoEntity projeto;

    @ManyToOne
    @JoinColumn(name = "idpessoa", referencedColumnName = "id", nullable = false)
    private PessoaEntity pessoa;

}
