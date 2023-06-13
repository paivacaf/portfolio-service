package com.nomadit.api.portfolio.infrastructure.persistence.repositories;


import com.nomadit.api.portfolio.infrastructure.persistence.entities.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProjetoJpaRepository extends JpaRepository<ProjetoEntity, Long>,
        QuerydslPredicateExecutor<ProjetoEntity> {

}
