package it.spring.dto;

import it.spring.dto.runner.InsertNewTeam;
import it.spring.dto.runner.UpdateNewTeam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DtoApplication {

	public static void main(String[] args) {
		final Class<?>[] runner = new Class<?>[] {
				DtoApplication.class,
				InsertNewTeam.class,
				UpdateNewTeam.class
		};
		SpringApplication.run(runner, args);
	}
}
