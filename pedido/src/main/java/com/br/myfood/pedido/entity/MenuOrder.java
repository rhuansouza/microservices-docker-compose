package com.br.myfood.pedido.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="tb_menu_order")
@NoArgsConstructor
@AllArgsConstructor
public class MenuOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long idMenu;
    private Long idRestaurant;
}
