package com.fissionlabs.coe.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fissionlabs.coe.model.Customer;
import com.fissionlabs.coe.util.KafkaUtility;

@RestController
public class CustomerController {

	Customer customerTopic = null;

		@GetMapping("/consumeJsonMessage")
	public Customer consumeJsonMessage() {
		return customerTopic;
	}

	
	@KafkaListener(groupId = KafkaUtility.GROUP_ID, topics = KafkaUtility.TOPIC, containerFactory = "customerKafkaListenerContainerFactory")
	public Customer getJsonMsgFromTopic(Customer customer) {
		customerTopic = customer;
		System.out.println(customer);
		return customerTopic;
	}
}
