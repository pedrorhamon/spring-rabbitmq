package com.starking.estoque.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RabbitMQService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	public void enviaMensagem(String nomeFila, Object mensagem) {
		try {
			String writeValueAsString = this.objectMapper.writeValueAsString(mensagem);
			this.rabbitTemplate.convertAndSend(nomeFila, writeValueAsString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
