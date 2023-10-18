package com.br.myfood.cadastro.controller;

import com.br.myfood.cadastro.dto.ClientDto;
import com.br.myfood.cadastro.entity.Client;
import com.br.myfood.cadastro.service.ClientService;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertClient(@RequestBody  ClientDto clientDto){
        System.out.println(clientDto);
        log.info("Passou na rota de cadastro de cliente");
        try{
            return ResponseEntity.ok(clientService.insertClient(Client.create(clientDto)));
        }catch(Exception e){
            ResponseEntity.badRequest().body(e);
        }

        return ResponseEntity.ok(clientDto);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateClient(@PathVariable("id") Long id, @RequestBody ClientDto clientDto){
        Client client = Client.create(clientDto);
        client.setId(id);
        Client updatedClient = clientService.updateClient(client);

        return Objects.nonNull(updatedClient) ? ResponseEntity.ok(updatedClient) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") Long id){
        return clientService.deleteClient(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Optional<Client> client = clientService.findById(id);

        return client.isPresent() ? ResponseEntity.ok(client.get()) : ResponseEntity.notFound().build();
    }




}
