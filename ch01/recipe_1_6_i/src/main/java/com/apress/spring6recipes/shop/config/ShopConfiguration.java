package com.apress.spring6recipes.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.apress.spring6recipes.shop.Disc;
import com.apress.spring6recipes.shop.Battery;
import com.apress.spring6recipes.shop.Product;

@Configuration
@PropertySource("classpath:discounts.properties")
@ComponentScan("com.apress.spring6recipes.shop")
public class ShopConfiguration {

	@Value("${endofyear.discount:0}")
	private double specialEndOfYearDiscountField;

	@Bean
	public static PropertySourcesPlaceholderConfigurer pspc() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Product dvdrw() {
		return new Disc("DVD-RW", 1.5, 4700, specialEndOfYearDiscountField);
	}
}
