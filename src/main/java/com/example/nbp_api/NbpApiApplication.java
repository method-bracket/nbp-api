package com.example.nbp_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "NBP API Application",
                version = "1.0",
                description = "An application that communicates with the NBP API."
        )
)
@SpringBootApplication
public class NbpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbpApiApplication.class, args);
	}

}
