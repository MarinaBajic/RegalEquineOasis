package com.reo.rider_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI riderServiceApi() {
        return new OpenAPI()
                .info(new Info().title("Rider Management Service API")
                        .description("REST API for Rider Management Service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")));
    }
}
