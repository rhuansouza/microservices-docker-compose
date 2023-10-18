package com.br.myfood.cadastro.entity;

import com.br.myfood.cadastro.dto.ClientDto;


import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
@Entity
@Table(name="tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String password;

    public static Client create(ClientDto clientDTO){
        return new ModelMapper().map(clientDTO, Client.class);
    }

}

