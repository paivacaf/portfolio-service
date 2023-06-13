package com.nomadit.api.portfolio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Membro {
    private Projeto projeto;
    private Pessoa pessoa;
}
