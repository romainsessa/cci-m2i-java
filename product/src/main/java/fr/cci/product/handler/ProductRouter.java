package fr.cci.product.handler;

import org.springframework.web.reactive.function.server.ServerResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class ProductRouter {

	@Bean
	public RouterFunction<ServerResponse> route(ProductHandler productHandler) {
		return RouterFunctions.route()
				.GET("/product/{name}", accept(MediaType.APPLICATION_JSON), productHandler::getProductByName)
				.GET("/product", accept(MediaType.APPLICATION_JSON), productHandler::getProducts)
				.POST("/product", accept(MediaType.APPLICATION_JSON), productHandler::createProduct)
				.build();
	}	
	
}