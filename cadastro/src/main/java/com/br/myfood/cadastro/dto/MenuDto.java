package com.br.myfood.cadastro.dto;

import com.br.myfood.cadastro.entity.Menu;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {

    private String name;
    private Double price;
    private Long idRestaurant;

    public static MenuDto create(Menu menu) {
        return new ModelMapper().map(menu, MenuDto.class);
    }
}
