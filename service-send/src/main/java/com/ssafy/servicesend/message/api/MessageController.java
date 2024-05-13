package com.ssafy.servicesend.message.api;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.ssafy.servicesend.message.dto.Greeting;
import com.ssafy.servicesend.message.dto.HelloMessage;
import com.ssafy.servicesend.message.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MessageController {

    private final ChatService chatService;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(
        HelloMessage message) throws Exception {
        return new Greeting("Hello, Your Msg too room " + " : " + HtmlUtils.htmlEscape(message.getName()) + ", Well Received!");
    }
}
