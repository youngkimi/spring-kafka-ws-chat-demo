package com.ssafy.servicesend.message.api;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import com.ssafy.servicesend.message.dto.request.ChatRequest;
import com.ssafy.servicesend.message.dto.response.ChatResponse;
import com.ssafy.servicesend.message.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller @CrossOrigin("*")
public class MessageController {

    private final ChatService chatService;

    @MessageMapping("/{roomId}")
    @SendTo("/room/{roomId}")
    public ChatResponse greeting(
        @DestinationVariable("roomId") Integer roomId,
        @Payload ChatRequest request) throws Exception {
        System.out.println(roomId);
        System.out.println(request);

        return ChatResponse.builder()
            .chatId(-1L)
            .message(request.getMessage())
            .nickname("예롬예롬")
            .senderId(3)
            .sendTime(LocalDateTime.now())
            .sentByMe(new Random().nextBoolean())
            .build();
    }

    @EventListener
    public void handleSubscribeEvent(SessionSubscribeEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String destination = headerAccessor.getDestination();

        System.out.println(headerAccessor.toString());

        System.out.println("subs info: " + destination);

        System.out.println(destination != null);
        System.out.println(destination.startsWith("/room/"));

        if (destination != null && destination.startsWith("/room")) {

            Pattern pattern = Pattern.compile("/room/(\\d+)(\\?)?"); // 물음표가 선택적인 정규 표현식
            Matcher matcher = pattern.matcher(destination);

            if (matcher.find()) {
                String number = matcher.group(1); // 첫 번째 캡처 그룹(숫자) 추출
                System.out.println("Extracted number: " + number); // 추출된 숫자 출력
            } else {
                System.out.println("No number found in the string.");
            }
        }

    }

    @EventListener
    public void handleDisconnectEvent(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());


        System.out.println(headerAccessor.toString());

        System.out.println("disconnected");
    }
}
