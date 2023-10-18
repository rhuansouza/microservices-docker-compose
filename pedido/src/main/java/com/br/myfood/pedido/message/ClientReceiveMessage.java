package com.br.myfood.pedido.message;

import com.br.myfood.pedido.dto.ClientOrderDto;
import com.br.myfood.pedido.entity.ClientOrder;
import com.br.myfood.pedido.repository.ClientOrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClientReceiveMessage {

    private final ClientOrderRepository clientOrderRepository;
    @Autowired
    public ClientReceiveMessage(ClientOrderRepository clientOrderRepository) {
        this.clientOrderRepository = clientOrderRepository;
    }

    @RabbitListener(queues = {"${fila.cadastro}"})
    public void receive(@Payload String payload) {
        System.out.println("teste "+payload);
        try {
        ObjectMapper mapper = new ObjectMapper();
        ClientOrderDto clientOrderDto = mapper.readValue(payload, ClientOrderDto.class);
        System.out.println(clientOrderDto);
        clientOrderRepository.save(new ClientOrder(null, clientOrderDto.getIdClient()));
        } catch (Exception e) {
            System.out.println("Erro ao receber solicitacao de envio de cadasto");
        }
    }

}
