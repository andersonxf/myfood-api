package com.andersonxf.myfood;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.andersonxf.myfood.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class MyfoodApiApplication {

	public static void main(String[] args) {
		
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		SpringApplication.run(MyfoodApiApplication.class, args);
	}

}
