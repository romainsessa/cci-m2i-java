package fr.cci.k_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KConsumerApplication.class, args);
	}

}
