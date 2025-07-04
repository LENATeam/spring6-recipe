package com.apress.spring6recipes.shop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Cashier {

	private final String fileName;
	private final String path;

	private BufferedWriter writer;

	public Cashier(String fileName, String path) {
		this.fileName = fileName;
		this.path = path;
	}

	@PostConstruct
	public void openFile() throws IOException {
		var options = new OpenOption[] {
						StandardOpenOption.CREATE,
						StandardOpenOption.APPEND };
		Files.createDirectories(Path.of(path));
		writer = Files.newBufferedWriter(Path.of(path, fileName),
						StandardCharsets.UTF_8,
						options);
	}

	public void checkout(ShoppingCart cart) throws IOException {
		writer.write(LocalDateTime.now() + "\t" + cart.getItems() + "\r\n");
		writer.flush();
	}

	@PreDestroy
	public void closeFile() throws IOException {
		writer.close();
	}
}
