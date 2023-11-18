package com.apress.spring6recipes.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.apress.spring6recipes.shop.config.ShopConfiguration;

public class Main {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

		Product dvdrw = context.getBean("dvdrw", Product.class);

		ShoppingCart cart = context.getBean("shoppingCart", ShoppingCart.class);
		cart.addItem(dvdrw);
		System.out.println("Shopping cart 2 contains " + cart.getItems());

	}

}
