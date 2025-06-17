package fr.cci.product.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import fr.cci.product.model.Product;
import reactor.core.publisher.Mono;

public interface ReactiveProductRepository 
	extends ReactiveMongoRepository<Product, String> {
	
	public Mono<Product> findByName(String name);

}
