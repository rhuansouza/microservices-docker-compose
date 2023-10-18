package com.br.myfood.pedido.repository;

import com.br.myfood.pedido.entity.MenuOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuOrderRepository extends JpaRepository<MenuOrder, Long> {
}
