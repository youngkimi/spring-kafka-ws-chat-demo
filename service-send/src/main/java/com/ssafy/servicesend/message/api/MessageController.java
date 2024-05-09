package com.ssafy.servicesend.message.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class MessageController {

    @GetMapping("/health-check")
    public ResponseEntity<?> healthCheck() {

        return new ResponseEntity<String>("healthy", HttpStatus.OK);
    }
}
