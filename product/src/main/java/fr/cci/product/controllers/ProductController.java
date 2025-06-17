package fr.cci.product.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cci.product.model.Product;
import fr.cci.product.repository.ReactiveProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

	private ReactiveProductRepository productRepository;

	public ProductController(ReactiveProductRepository productRepository) {
		this.productRepository = productRepository;
	}

//	@GetMapping("/product/{name}")
//	public Mono<Product> getProductByName(@PathVariable("name") String name) {
//
//		return this.productRepository.findByName(name);
//
//	}

//	@PostMapping("/product/{name}")
//	public Flux<Product> addProduct(@PathVariable("name") String name) {
//
//		Product newProduct = new Product(name);
//		this.productRepository.insert(newProduct)
//			.subscribe(result -> System.out.println("Document saved : " + result.toString()));
//		
//		return this.productRepository.findAll();
//
//	}

}
