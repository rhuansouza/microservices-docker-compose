package com.br.myfood.pedido.repository;

import com.br.myfood.pedido.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemRepository extends JpaRepository<Order, Long> {
}
