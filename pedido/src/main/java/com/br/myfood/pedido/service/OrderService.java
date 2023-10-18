package com.br.myfood.pedido.service;

import com.br.myfood.pedido.entity.Order;
import com.br.myfood.pedido.repository.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrdemRepository ordemRepository;

    @Autowired
    public OrderService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    public Order insertOrder(Order order){
        return ordemRepository.save(order);
    }

}
