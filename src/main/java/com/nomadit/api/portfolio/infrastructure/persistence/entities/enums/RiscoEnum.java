package com.nomadit.api.portfolio.infrastructure.persistence.entities.enums;

public enum RiscoEnum {

    BAIXO_RISCO("Baixo risco"),
    MEDIO_RISCO("Médio risco"),
    ALTO_RISCO("Alto risco");

    RiscoEnum(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
