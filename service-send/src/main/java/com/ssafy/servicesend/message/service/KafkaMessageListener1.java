package com.ssafy.servicesend.message.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ssafy.servicesend.message.api.MessageDto;

@Component
public class KafkaMessageListener1 {

	@KafkaListener(topics = "create-diary", groupId = "group_1")
	public void handleRecommendTask(MessageDto message) {

		System.out.println("Listener1 sender:" + message.getSender());
		System.out.println("Listener1 message:" + message.getMessage());
	}
}
