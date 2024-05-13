package com.ssafy.servicesend.message.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatService {

	// private final KafkaTemplate<String, Object> kafkaTemplate;
	//
	// public void messageToKafka(MessageDto message) {
	// 	kafkaTemplate.send("topic-test", message.getMessage());
	// }
	//
	// @KafkaListener(topics = "topic-test", groupId = "group_1")
	// public void messageFromKafka(Object data) {
	// 	System.out.println("RECEIVED MSG FROM KAFKA");
	// 	System.out.println(data);
	// }

}
