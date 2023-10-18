package com.br.myfood.cadastro.dto;

import com.br.myfood.cadastro.entity.Client;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
public class ClientOrderDto {

    private String name;
    private Long idClient;

    public static ClientOrderDto create(Client client) {
        return new ModelMapper().map(client, ClientOrderDto.class);
    }

}
