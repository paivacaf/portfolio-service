package com.nomadit.api.portfolio.application.exceptions;

import lombok.Data;

@Data
public class RegraDeNegocioNaoAtendidaException extends RuntimeException {

    private String mensagem;
    public RegraDeNegocioNaoAtendidaException(String mensagem) {this.mensagem = mensagem;}
}
