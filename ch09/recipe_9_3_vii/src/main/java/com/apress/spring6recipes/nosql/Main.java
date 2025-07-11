package com.apress.spring6recipes.nosql;

import java.util.stream.Stream;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		var cfg = StarwarsConfig.class;
		try (var ctx = new AnnotationConfigApplicationContext(cfg)) {
			var service = ctx.getBean(StarwarsService.class);

			// Planets
			var dagobah = new Planet("Dagobah");
			var alderaan = new Planet("Alderaan");
			var tatooine = new Planet("Tatooine");

			Stream.of(dagobah, alderaan, tatooine).forEach(service::save);

			// Characters
			var han = new Character("Han Solo");
			var leia = new Character("Leia Organa");
			leia.setLocation(alderaan);
			leia.addFriend(han);

			var luke = new Character("Luke Skywalker");
			luke.setLocation(tatooine);
			luke.addFriend(han);
			luke.addFriend(leia);

			var yoda = new Character("Yoda");
			yoda.setLocation(dagobah);
			yoda.setApprentice(luke);

			Stream.of(han, luke, leia, yoda).forEach(service::save);
			service.printAll();
		}
	}
}
