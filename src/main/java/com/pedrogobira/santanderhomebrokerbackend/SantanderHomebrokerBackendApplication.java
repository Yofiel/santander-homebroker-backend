package com.pedrogobira.santanderhomebrokerbackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class SantanderHomebrokerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantanderHomebrokerBackendApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application.name}") String name,
			@Value("${application.description}") String description, @Value("${application.version}") String version) {
		return new OpenAPI().info(new Info().title(name).description(description).version(version)
				.termsOfService("http://swagger.io/terms")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
