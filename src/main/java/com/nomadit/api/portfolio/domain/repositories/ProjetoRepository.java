package com.nomadit.api.portfolio.domain.repositories;


import com.nomadit.api.portfolio.domain.model.Projeto;

import java.util.List;

public interface ProjetoRepository {
    void salvar(Projeto projeto);
    Projeto obterPorId(Long id);
    List<Projeto> obterTodos();
    List<Projeto> obterTodos(Projeto projeto, int page, int size);
    void excluir(Projeto projeto);
    void excluirPorId(Long projetoId);
}
