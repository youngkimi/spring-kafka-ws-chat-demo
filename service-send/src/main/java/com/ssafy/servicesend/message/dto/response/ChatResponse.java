package com.ssafy.servicesend.message.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data @Builder
public class ChatResponse {
	Long chatId;
	Integer senderId;
	String nickname;
	String profileImgUrl;
	LocalDateTime sendTime;
	String message;
	boolean sentByMe;

}
