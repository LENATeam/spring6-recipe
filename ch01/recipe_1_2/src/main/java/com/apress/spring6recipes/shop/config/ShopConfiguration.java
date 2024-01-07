package com.apress.spring6recipes.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apress.spring6recipes.shop.Disc;
import com.apress.spring6recipes.shop.Battery;
import com.apress.spring6recipes.shop.Product;

@Configuration
public class ShopConfiguration {

	@Bean
	public Product aaa() {
		return new Battery("AAA", 2.5, true);
	}

	@Bean
	public Product cdrw() {
		return new Disc("CD-RW", 1.5, 700);
	}
}
