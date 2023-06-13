package com.nomadit.api.portfolio.infrastructure.persistence.adapters;


import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.ProjetoEntity;
import com.nomadit.api.portfolio.infrastructure.persistence.exceptions.ProjetoNotFoundException;
import com.nomadit.api.portfolio.infrastructure.persistence.mappers.EntityMappers;
import com.nomadit.api.portfolio.infrastructure.persistence.repositories.ProjetoJpaRepository;
import com.nomadit.api.portfolio.infrastructure.persistence.utils.PredicateUtils;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjetoPersistenceAdapter implements ProjetoRepository {

    private final ProjetoJpaRepository projetoJpaRepository;
    private final EntityMappers entityMappers;
    private final EntityManager entityManager;

    @Override
    public void salvar(Projeto projeto) {
        ProjetoEntity entity = Optional.of(projeto)
                .map(entityMappers::projectToProjetoEntity)
                .orElseThrow();
        projetoJpaRepository.save(entity);
    }

    @Override
    public Projeto obterPorId(Long id) {
        ProjetoEntity projetoEntity = projetoJpaRepository.findById(id)
                .orElseThrow(() -> new ProjetoNotFoundException("Projeto não encontrado"));
        return entityMappers.projectEntityToProjeto(projetoEntity);
    }

    @Override
    public List<Projeto> obterTodos() {
        return projetoJpaRepository.findAll().stream()
                .map(entityMappers::projectEntityToProjeto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Projeto> obterTodos(Projeto projeto, int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Predicate predicate = PredicateUtils.criarPredicate(entityManager, ProjetoEntity.class, entityMappers.projectToProjetoEntity(projeto));
        return projetoJpaRepository.findAll(predicate, pageable).getContent().stream()
                .map(entityMappers::projectEntityToProjeto)
                .collect(Collectors.toList());
    }

    public Page<Projeto> obterTodos(@QuerydslPredicate(root = Projeto.class) Predicate predicate, Pageable pageable) {
        return projetoJpaRepository.findAll(predicate, pageable)
                .map(entityMappers::projectEntityToProjeto);
    }

    @Override
    public void excluir(Projeto projeto) {
        projetoJpaRepository.delete(entityMappers.projectToProjetoEntity(projeto));
    }

    @Override
    public void excluirPorId(Long projetoId) {
        projetoJpaRepository.deleteById(projetoId);
    }

}
