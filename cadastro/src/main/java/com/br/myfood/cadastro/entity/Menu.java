package com.br.myfood.cadastro.entity;

import com.br.myfood.cadastro.dto.ClientDto;
import com.br.myfood.cadastro.dto.MenuDto;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
@Entity
@Table(name="tb_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)//so busca o dado quando for dar um get
    private Restaurant restaurant;

    public static Menu create(MenuDto menuDto){
        return new ModelMapper().map(menuDto, Menu.class);
    }

}

