package fr.cci.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.cci.product.model.Product;
import fr.cci.product.repository.ReactiveProductRepository;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

	@Autowired
	private ReactiveProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*Product product = new Product("test");
		
		productRepository
			.insert(product)
			.subscribe(
					result -> System.out.println("Product saved : " + result.toString())
					);
		
		Mono<Product> monoProduct = 
				productRepository.findByName("test");
		
		monoProduct.subscribe(
				result -> {
					System.out.println("Product retrieved : " + result.toString());
					//productRepository.deleteById(result.getId()).subscribe();					
					}				
				);
		
		
		*/
		
	}

}
