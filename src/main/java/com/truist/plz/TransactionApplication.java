package com.truist.plz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.truist.plz.model.Abc;
import com.truist.plz.model.Bar;
import com.truist.plz.model.Foo;
import com.truist.plz.service.TransactionService;

@SpringBootApplication
public class TransactionApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TransactionApplication.class);

	@Autowired
	private TransactionService service;

	@Override
	public void run(String... args) throws Exception {
		Collection<Object> resultValues = service.getValues(
				new Foo(List.of(new Abc(null, "1"), new Abc("TestName2", "2")), new Bar(new Abc(null, "3"), "bar")));
		Path fileName = Path.of("C:\\SHRGSpace\\Truist\\STS_WORKSPACE\\demo.xls");
		// resultValues.forEach(e -> System.out.print(e + "\u241F"));
		/*
		 * for (int i = 1; i < resultValues.size() - 1; i++) { System.out.print((List)
		 * resultValues + "\u241F"); inputToFile.append(i + "\u241F"); }
		 */
		/*
		 * Object object = resultValues.stream().collect(StringBuilder::new, (x, y) ->
		 * x.append(y), (a, b) -> a.append(",").append(b));
		 */

		StringBuilder result1 = resultValues.parallelStream().collect(StringBuilder::new, (x, y) -> x.append(y),
				(a, b) -> a.append("\u241F").append(b));
		System.out.println(result1.toString());
		try {
			Files.writeString(fileName, result1.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}
}