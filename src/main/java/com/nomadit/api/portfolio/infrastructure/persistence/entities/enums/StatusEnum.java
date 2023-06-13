package com.nomadit.api.portfolio.infrastructure.persistence.entities.enums;

public enum StatusEnum {

    EM_ANALISE("Em análise"),
    ANALISE("Análise"),
    ANALISE_REALIZADA("Análise realizada"),
    ANALISE_APROVADA("Análise aprovada"),
    INICIADO("Iniciado"),
    PLANEJADO("Planejado"),
    EM_ANDAMENTO("Em andamento"),
    ENCERRADO("Encerrado"),
    CANCELADO("Cancelado");

    private String descricao;

    StatusEnum(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
