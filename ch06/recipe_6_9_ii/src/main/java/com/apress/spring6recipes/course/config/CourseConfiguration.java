package com.apress.spring6recipes.course.config;

import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;

import org.hibernate.dialect.PostgreSQL95Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.apress.spring6recipes.course")
public class CourseConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPackagesToScan("com.apress.spring6recipes.course");
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(jpaVendorAdapter());
		return emf;
	}

	private JpaVendorAdapter jpaVendorAdapter() {

		var jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setGenerateDdl(true);
		return jpaVendorAdapter;
	}

	@Bean
	public DataSource dataSource() {

		var dataSource = new HikariDataSource();
		dataSource.setUsername("postgres");
		dataSource.setPassword("password");
		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/course");
		dataSource.setMinimumIdle(2);
		dataSource.setMaximumPoolSize(5);
		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
