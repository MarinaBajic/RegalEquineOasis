package com.reo.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/api/horses/**").uri("lb://horse-service"))
                .route(p -> p.path("/api/riders/**").uri("lb://rider-service"))
                .route(p -> p.path("/api/favorites/**").uri("lb://rider-service"))
                .route(p -> p.path("/api/sessions/**").uri("lb://rider-service"))
//                .route(p -> p.path("/aggregate/horse-service/v3/api-docs")
//                        .filters(f -> f.rewritePath("/aggregate/horse-service/v3/api-docs", "/api-docs"))
//                        .uri("lb://horse-service"))
//                .route(p -> p.path("/aggregate/rider-service/v3/api-docs")
//                        .filters(f -> f.rewritePath("/aggregate/rider-service/v3/api-docs", "/api-docs"))
//                        .uri("lb://rider-service"))
                .build();
    }
}
