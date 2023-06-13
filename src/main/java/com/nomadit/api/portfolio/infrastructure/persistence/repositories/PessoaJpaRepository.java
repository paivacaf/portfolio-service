package com.nomadit.api.portfolio.infrastructure.persistence.repositories;

import com.nomadit.api.portfolio.infrastructure.persistence.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaJpaRepository extends JpaRepository<PessoaEntity, Long>, QuerydslPredicateExecutor<PessoaEntity> {
}
