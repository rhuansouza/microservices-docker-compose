package com.br.myfood.pedido.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long idClient;
    private Long idRestaurant;
    private Long idMenu;
}
