package com.reo.api_gateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiGatewayApi() {
        return new OpenAPI()
                .info(new Info().title("API Gateway")
                        .description("API Gateway")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")));
    }
}
