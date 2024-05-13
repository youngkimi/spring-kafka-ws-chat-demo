package com.ssafy.servicesend.message.api;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.ssafy.servicesend.message.dto.Greeting;
import com.ssafy.servicesend.message.dto.HelloMessage;
import com.ssafy.servicesend.message.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HealthController {

    private final ChatService chatService;
    
    @GetMapping("/hello")
    public Greeting greeting() {
        return new Greeting("health-check OK!");
    }
}
