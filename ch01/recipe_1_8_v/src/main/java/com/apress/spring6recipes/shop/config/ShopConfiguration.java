package com.apress.spring6recipes.shop.config;

import com.apress.spring6recipes.shop.Battery;
import com.apress.spring6recipes.shop.Cashier;
import com.apress.spring6recipes.shop.Disc;
import com.apress.spring6recipes.shop.Product;
import com.apress.spring6recipes.shop.ShoppingCart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.apress.spring6recipes.shop")
public class ShopConfiguration {

	@Bean
	public Product aaa() {
		return new Battery("AAA", 2.5, true);
	}

	@Bean
	public Product cdrw() {
		return new Disc("CD-RW", 1.5, 700);
	}

	@Bean
	public Product dvdrw() {
		return new Disc("DVD-RW", 3.0, 4700);
	}

	@Bean
	public ShoppingCart cart1() {
		return new ShoppingCart();
	}

	@Bean
	public ShoppingCart cart2() {
		return new ShoppingCart();
	}

	@Bean
	public Cashier cashier() {
		var path = System.getProperty("java.io.tmpdir") + "/cashier";
		return new Cashier("checkout", path);
	}
}
