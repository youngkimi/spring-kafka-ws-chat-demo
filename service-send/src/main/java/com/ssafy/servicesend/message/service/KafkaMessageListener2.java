package com.ssafy.servicesend.message.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ssafy.servicesend.message.api.MessageDto;

@Component
public class KafkaMessageListener2 {

	@KafkaListener(topics = "create-diary", groupId = "group_2")
	public void handleRecommendTask(MessageDto message) {

		System.out.println("Listener2 sender:" + message.getSender());
		System.out.println("Listener2 message:" + message.getMessage());
	}

}
