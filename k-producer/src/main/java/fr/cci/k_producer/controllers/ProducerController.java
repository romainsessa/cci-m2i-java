package fr.cci.k_producer.controllers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.cci.common.EventDTO;
import fr.cci.k_producer.dtos.MessageDTO;

@RestController
public class ProducerController {

	private KafkaTemplate<String, EventDTO> kafkaTemplate;
	
	public ProducerController(KafkaTemplate<String, EventDTO> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	@PostMapping("/send")
	public void sendMessage(@RequestBody MessageDTO message) { 
		
		EventDTO event = new EventDTO(message.getValue(), "...");
		
		this.kafkaTemplate.send(
				"events", 
				message.getKey(), 
				event);
	}
	
}
