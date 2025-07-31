package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
			basePackages = "com.example.demo.postgres.repository",
			entityManagerFactoryRef = "postgresEntityManagerFactory",
			transactionManagerRef = "postgresTransactionalManager"
		)
public class PostgresRepositoryConfig {

}
