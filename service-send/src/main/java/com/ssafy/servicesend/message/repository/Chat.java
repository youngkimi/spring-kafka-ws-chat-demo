package com.ssafy.servicesend.message.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Chat {

	@Id
	@Column(name = "chat_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String message;

	Long senderId;



}
