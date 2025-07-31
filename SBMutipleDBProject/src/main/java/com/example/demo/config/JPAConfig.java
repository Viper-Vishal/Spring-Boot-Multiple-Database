package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class JPAConfig {
	
	@Primary
	@Bean( name = "mysqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
				EntityManagerFactoryBuilder builder,
				@Qualifier("mysqlDataSource") DataSource datasource
			) {
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.hbm2ddl", "update");
		
		return builder
					.dataSource(datasource)
					.packages("com.example.demo.mysql.entity")
					.properties(properties)
					.persistenceUnit("mysql")
					.build();
	}
	
	@Bean(name = "postgresEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
				EntityManagerFactoryBuilder builder,
				@Qualifier("postgresDataSource") DataSource datasource
			) {
		
		Map properties = new HashMap<>();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return builder
					.dataSource(datasource)
					.packages("com.example.demo.postgres.entity")
					.properties(properties)
					.persistenceUnit("postgres")
					.build();
	}
	
	@Bean(name = "mysqlTransactionManager")
	public PlatformTransactionManager mysqlTransactionManager(
				@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory factory
			) {
		return new JpaTransactionManager(factory);
	}
	
	@Bean(name = "postgresTransactionalManager")
	public PlatformTransactionManager postgresTransactionalManager(
				@Qualifier("postgresEntityManagerFactory") EntityManagerFactory factory
			) {
		return new JpaTransactionManager(factory);
	}
}
