package com.br.myfood.cadastro.message;

import com.br.myfood.cadastro.dto.ClientOrderDto;
import com.br.myfood.cadastro.service.MyMessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientSendMessage {
    

    private final RabbitTemplate rabbitTemplate;
    private final MyMessageService myMessageService;

    @Value("${chave.cadastro}")
    private String chaveCadastro;

    @Autowired
    public ClientSendMessage(RabbitTemplate rabbitTemplate, MyMessageService myMessageService) {
        this.rabbitTemplate = rabbitTemplate;
        this.myMessageService = myMessageService;
    }

    public void sendMessage(ClientOrderDto client) {
        System.out.println(client);
        System.out.println(chaveCadastro);
        // Criar um objeto ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Serializar o objeto em uma string JSON
            String json = objectMapper.writeValueAsString(client);
            myMessageService.sendMessage(json, chaveCadastro);
        }catch (JsonProcessingException e) {
            System.out.println("Deu erro "+e.getMessage());
            e.printStackTrace();
        }



        //rabbitTemplate.convertAndSend(exchange, routingkey, client);
    }

}