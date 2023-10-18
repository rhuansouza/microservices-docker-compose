package com.br.myfood.cadastro.dto;

import com.br.myfood.cadastro.entity.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuOrderDto {

    private Long idMenu;
    private String name;
    private Double price;
    private Long idRestaurant;

    public static MenuOrderDto create(Menu menu) {
        return new ModelMapper().map(menu, MenuOrderDto.class);
    }
}