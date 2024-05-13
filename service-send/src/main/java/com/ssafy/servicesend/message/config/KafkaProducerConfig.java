package com.ssafy.servicesend.message.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

	// @Bean
	// public ProducerFactory<String, Object> producerFactory() {
	// 	Map<String, Object> config = new HashMap<>();
	// 	// Producer가 처음으로 연결할 Kafka 브로커의 위치 설정
	// 	config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:19094");
	//
	//
	// 	// 송신 데이터(key, value) 직렬화
	// 	config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	// 	config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	//
	// 	return new DefaultKafkaProducerFactory<>(config);
	// }
	//
	// @Bean
	// public KafkaTemplate<String, Object> kafkaTemplate() {
	// 	return new KafkaTemplate<>(producerFactory());
	// }

}
