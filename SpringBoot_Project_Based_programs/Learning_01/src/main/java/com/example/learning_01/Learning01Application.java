package com.example.learning_01;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Learning01Application {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach((entry)->System.setProperty(
				entry.getKey(),entry.getValue()
		));

		SpringApplication.run(Learning01Application.class, args);
	}

}
