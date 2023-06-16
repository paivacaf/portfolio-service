package com.nomadit.api.portfolio.infrastructure.persistence.adapters;


import com.nomadit.api.portfolio.application.exceptions.NenhumConteudoEncontradoException;
import com.nomadit.api.portfolio.domain.model.Pessoa;
import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.PessoaEntity;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.ProjetoEntity;
import com.nomadit.api.portfolio.infrastructure.persistence.mappers.EntityMappers;
import com.nomadit.api.portfolio.infrastructure.persistence.repositories.PessoaJpaRepository;
import com.nomadit.api.portfolio.infrastructure.persistence.repositories.ProjetoJpaRepository;
import com.nomadit.api.portfolio.infrastructure.persistence.utils.PredicateUtils;
import com.nomadit.api.portfolio.shared.PersistenceAdapter;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProjetoPersistenceAdapter implements ProjetoRepository {

    private final ProjetoJpaRepository projetoJpaRepository;
    private final EntityMappers entityMappers;
    private final EntityManager entityManager;

    @Override
    public Projeto criarProjeto(Projeto projeto) {
        return Optional.of(projeto)
                .map(entityMappers::projectToProjetoEntity)
                .map(projetoJpaRepository::save)
                .map(entityMappers::projectEntityToProjeto)
                .orElseThrow();
    }

    @Override
    public Projeto obterPorId(Long id) {



        return projetoJpaRepository.findById(id)
                .map(entityMappers::projectEntityToProjeto)
                .orElseThrow(() -> new NenhumConteudoEncontradoException());
    }

    @Override
    public List<Projeto> listarProjetos() {
        return projetoJpaRepository.findAll()
                .stream()
                .map(entityMappers::projectEntityToProjeto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Projeto> pesquisarProjetos(Projeto projeto, int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Predicate predicate = PredicateUtils.criarPredicate(entityManager, ProjetoEntity.class, entityMappers.projectToProjetoEntity(projeto));
        return projetoJpaRepository.findAll(predicate, pageable).getContent().stream()
                .map(entityMappers::projectEntityToProjeto)
                .collect(Collectors.toList());
    }

    @Override
    public void excluir(Projeto projeto) {
        ProjetoEntity projetoEntity = Optional.of(projeto)
                .map(entityMappers::projectToProjetoEntity)
                .orElseThrow();
        projetoJpaRepository.delete(projetoEntity);
    }

    @Override
    public void excluirPorId(Long projetoId) {
        projetoJpaRepository.deleteById(projetoId);
    }

}
