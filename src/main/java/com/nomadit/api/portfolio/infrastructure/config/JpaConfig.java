package com.nomadit.api.portfolio.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.nomadit.api.portfolio.infrastructure.persistence.repositories.*"})
@EntityScan("com.nomadit.api.portfolio.infrastructure.persistence.entities")
public class JpaConfig {
}
