package com.br.myfood.cadastro.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyMessageService {

    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName = "minha-exchange";
    private final String routingKeyCadastro = "chave-cadastro";

    public MyMessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message, String routingKey) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}
