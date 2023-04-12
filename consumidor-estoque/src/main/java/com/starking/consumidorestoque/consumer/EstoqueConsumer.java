package com.starking.consumidorestoque.consumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starking.librabbitmq.constantes.RabbitMQConstantes;
import com.starking.librabbitmq.dtos.EstoqueDTO;



@Component
public class EstoqueConsumer {

  @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
  private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException {
    EstoqueDTO estoqueDto = new ObjectMapper().readValue(mensagem, EstoqueDTO.class);

    System.out.println(estoqueDto.codigoProduto);
    System.out.println(estoqueDto.quantidade);
    System.out.println("------------------------------------");

    throw new IllegalArgumentException("Argumento inválido!");
  }
}