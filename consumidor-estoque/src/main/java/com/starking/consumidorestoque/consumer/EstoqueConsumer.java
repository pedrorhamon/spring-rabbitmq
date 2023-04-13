package com.starking.consumidorestoque.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constantes.RabbitmqConstantes;
import dto.EstoqueDto;

@Component
public class EstoqueConsumer {

	@RabbitListener(queues = RabbitmqConstantes.FILA_ESTOQUE)
	private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException {
		EstoqueDto estoqueDto = new ObjectMapper().readValue(mensagem, EstoqueDto.class);

		System.out.println(estoqueDto.codigoproduto);
		System.out.println(estoqueDto.quantidade);
		System.out.println("------------------------------------");

		throw new IllegalArgumentException("Argumento inválido!");
	}
}