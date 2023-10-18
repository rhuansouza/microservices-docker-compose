package com.br.myfood.pedido.repository;

import com.br.myfood.pedido.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {
}
