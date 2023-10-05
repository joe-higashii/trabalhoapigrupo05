package com.trabalhoapigrupo05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
// informações basicas da api
@OpenAPIDefinition(info = @Info(title = "Adoção de cães", version = "1", description = "API para adoção de cães"))
public class Trabalhoapigrupo05Application {

	public static void main(String[] args) {
		SpringApplication.run(Trabalhoapigrupo05Application.class, args);
	}

}
