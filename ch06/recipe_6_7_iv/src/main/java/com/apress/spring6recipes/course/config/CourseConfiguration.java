package com.apress.spring6recipes.course.config;

import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.apress.spring6recipes.course.CourseDao;
import com.apress.spring6recipes.course.jpa.JpaCourseDao;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class CourseConfiguration {

	@Bean
	public CourseDao courseDao(EntityManagerFactory entityManagerFactory) {
		return new JpaCourseDao(entityManagerFactory);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceUnitName("course");
		emf.setDataSource(ds);
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
}
