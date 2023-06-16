package com.nomadit.api.portfolio.infrastructure.persistence.repositories;

import com.nomadit.api.portfolio.infrastructure.persistence.entities.MembrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroJpaRepository extends JpaRepository<MembrosEntity, Long> {
}
