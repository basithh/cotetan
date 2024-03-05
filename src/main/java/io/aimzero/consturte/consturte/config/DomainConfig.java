package io.aimzero.consturte.consturte.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.aimzero.consturte.consturte.domain")
@EnableJpaRepositories("io.aimzero.consturte.consturte.repos")
@EnableTransactionManagement
public class DomainConfig {
}
