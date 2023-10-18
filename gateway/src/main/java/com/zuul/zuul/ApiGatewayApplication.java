package com.zuul.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/cadastro/**") //rota
						//.filters(f -> f.filter(new ApiKeyFilter()))
						.uri("lb://cadastro"))//nome da aplicação
				.route(r -> r.path("/restaurant/**") //rota
						//.filters(f -> f.filter(new ApiKeyFilter()))
						.uri("lb://cadastro"))//nome da aplicação
				.route(r -> r.path("/menu/**") //rota
						//.filters(f -> f.filter(new ApiKeyFilter()))
						.uri("lb://cadastro"))//nome da aplicação
				.route(r -> r.path("/order/**") //rota
						//.filters(f -> f.filter(new ApiKeyFilter()))
						.uri("lb://pedido"))//nome da aplicação

				.build();
	}

}
