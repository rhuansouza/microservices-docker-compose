package com.br.myfood.pedido.message;

import com.br.myfood.pedido.dto.ClientOrderDto;
import com.br.myfood.pedido.dto.MenuOrderDto;
import com.br.myfood.pedido.entity.ClientOrder;
import com.br.myfood.pedido.entity.MenuOrder;
import com.br.myfood.pedido.repository.MenuOrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MenuReceiveMessage {

    private final MenuOrderRepository menuOrderRepository;

    @Autowired
    public MenuReceiveMessage(MenuOrderRepository menuOrderRepository) {
        this.menuOrderRepository = menuOrderRepository;
    }

    @RabbitListener(queues = {"${fila.menu}"})
    public void receiveMessage(@Payload String payload) {

        System.out.println("Mensagem fila menu: "+payload);

        try {
            ObjectMapper mapper = new ObjectMapper();
            MenuOrderDto menuOrderDto = mapper.readValue(payload, MenuOrderDto.class);
            System.out.println(menuOrderDto);
            menuOrderRepository.save(new MenuOrder(null, menuOrderDto.getIdMenu(),menuOrderDto.getIdRestaurant()));
        } catch (Exception e) {
            System.out.println("Erro ao receber solicitacao de envio de menu");
        }
    }

}