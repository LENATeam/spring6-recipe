package com.apress.spring6recipes.reactive.court;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

public class ReactorNettyBootstrap {

	public static void main(String[] args) throws Exception {
		var context = new AnnotationConfigApplicationContext(WebFluxConfiguration.class);
		var handler = WebHttpHandlerBuilder.applicationContext(context).build();

		var adapter = new ReactorHttpHandlerAdapter(handler);
		HttpServer.create().host("localhost").port(8080).handle(adapter).bind().block();

		System.out.println("Application ready on http://localhost:8080/members");
		System.out.println("Press [ENTER] to stop!");
		System.in.read();
	}
}
