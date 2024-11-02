package com.fmunoz.mutantesAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MutanteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutanteApiApplication.class, args);
	}
}
