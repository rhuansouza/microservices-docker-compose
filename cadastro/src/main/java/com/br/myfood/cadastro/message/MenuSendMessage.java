package com.br.myfood.cadastro.message;

import com.br.myfood.cadastro.dto.MenuOrderDto;
import com.br.myfood.cadastro.service.MyMessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MenuSendMessage {

    private final RabbitTemplate rabbitTemplate;
    private final MyMessageService myMessageService;

    @Value("${chave.menu}")
    private String chaveMenu;

    @Autowired
    public MenuSendMessage(RabbitTemplate rabbitTemplate, MyMessageService myMessageService) {
        this.rabbitTemplate = rabbitTemplate;
        this.myMessageService = myMessageService;
    }

    public void sendMessage(MenuOrderDto menuOrderDto) {
        System.out.println(menuOrderDto);
        System.out.println(chaveMenu);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Serializar o objeto em uma string JSON
            String json = objectMapper.writeValueAsString(menuOrderDto);
            myMessageService.sendMessage(json, chaveMenu);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //rabbitTemplate.convertAndSend(exchange, routingkey, menuOrderDto);
    }

}
