package com.ssafy.servicesend.message.api;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.servicesend.message.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController @CrossOrigin("*")
public class HealthController {

    private final ChatService chatService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/test")
    public ResponseEntity<?> createDiary(@RequestBody MessageDto message) {

        System.out.println("API RECEIVED!");

        kafkaTemplate.send("create-diary", message);

        return ResponseEntity.ok().build();
    }
}
