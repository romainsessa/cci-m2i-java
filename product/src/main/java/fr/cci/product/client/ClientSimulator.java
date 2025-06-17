package fr.cci.product.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import fr.cci.product.model.Product;
import reactor.core.publisher.Mono;

@Service
public class ClientSimulator 
	implements CommandLineRunner {

	@Autowired
	private WebClient webClient;
	
	@Override
	public void run(String... args) throws Exception {

		Mono<Product> result = webClient.get()
			.uri("/product/test")
			.retrieve()
			.bodyToMono(Product.class);
		
		result.subscribe( product -> System.out.println(product.toString()) ); 
		
		
	}

}
