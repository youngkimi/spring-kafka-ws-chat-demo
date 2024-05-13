package com.ssafy.servicesend.message.api;

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
@RequestMapping("/api/chat")
@Controller
public class MessageController {

    private final ChatService chatService;

    // @GetMapping("/health-check")
    // public ResponseEntity<?> healthCheck() {
    //
    //     return new ResponseEntity<String>("healthy", HttpStatus.OK);
    // }

    // @PostMapping("/message")
    // public ResponseEntity<?> sendMsg(@RequestBody MessageDto message) {
    //
    //     System.out.println(message);
    //
    //     chatService.messageToKafka(message);
    //
    //     return new ResponseEntity<String>("healthy", HttpStatus.OK);
    // }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
