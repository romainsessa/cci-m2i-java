package fr.cci.k_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import fr.cci.common.EventDTO;

@Service
public class ConsumerService {

	@KafkaListener(
			topics = "events",
			groupId = "test-consumer-group"
			)
	public void listEvents(
			@Header(KafkaHeaders.RECEIVED_KEY) String key, 
			EventDTO event) {
		
		System.out.println("Received event : " 
				+"\nkey : " + key
				+ "\nmessage :" + event.getName() + " " + event.getPassword());
		
	}
	
}
