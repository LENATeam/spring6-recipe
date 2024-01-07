package com.apress.spring6recipes.vehicle.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apress.spring6recipes.vehicle.PlainJdbcVehicleDao;
import com.apress.spring6recipes.vehicle.VehicleDao;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class VehicleConfiguration {

	@Bean
	public VehicleDao vehicleDao(DataSource dataSource) {
		return new PlainJdbcVehicleDao(dataSource);
	}

	@Bean
	public DataSource dataSource() {
		var dataSource = new HikariDataSource();
		// setDataSourceClassName or setJdbcUrl only one use
		// if use setDataSourceClassName, you can create vehicle table in postgres database
		dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource"); 
		// if use setJdbcUrl, you can create vehicle table in vehicle database
		// dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/vehicle");
		dataSource.setUsername("postgres");
		dataSource.setPassword("password");
		dataSource.setMinimumIdle(2);
		dataSource.setMaximumPoolSize(5);
		return dataSource;
	}
}
