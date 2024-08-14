package com.reo.horse_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI horseServiceApi() {
        return new OpenAPI()
                .info(new Info().title("Horse Management Service API")
                        .description("REST API for Horse Management Service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")));
    }
}
