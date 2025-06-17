package fr.cci.product.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import fr.cci.product.model.Product;
import fr.cci.product.repository.ReactiveProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
	
	private ReactiveProductRepository productRepository;
	
	public ProductHandler(ReactiveProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Mono<ServerResponse> getProductByName(ServerRequest request) {
		String name = request.pathVariable("name");
		return this.productRepository.findByName(name)
			.flatMap(product -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(product));
	}
	
	public Mono<ServerResponse> getProducts(ServerRequest request) {
		Flux<Product> products = this.productRepository.findAll();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products, Product.class);
	}
	
	public Mono<ServerResponse> createProduct(ServerRequest request) {
		Mono<Product> newProduct = request.bodyToMono(Product.class);
		return newProduct.flatMap( product -> {
			return this.productRepository.insert(product)
			.flatMap(p -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(p));
		});		
	}
	
}
