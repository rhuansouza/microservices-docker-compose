package com.br.myfood.cadastro.controller;


import com.br.myfood.cadastro.dto.RestaurantDto;
import com.br.myfood.cadastro.entity.Restaurant;
import com.br.myfood.cadastro.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertClient(@RequestBody RestaurantDto restaurantDto){
        System.out.println(restaurantDto);
        try{
            return ResponseEntity.ok(restaurantService.insertRestaurant(Restaurant.create(restaurantDto)));
        }catch(Exception e){
            ResponseEntity.badRequest().body(e);
        }

        return ResponseEntity.ok(restaurantDto);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateClient(@PathVariable("id") Long id, @RequestBody RestaurantDto clientDto){
        Restaurant restaurant = Restaurant.create(clientDto);
        restaurant.setId(id);
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);

        return Objects.nonNull(updatedRestaurant) ? ResponseEntity.ok(updatedRestaurant) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") Long id){
        return restaurantService.deleteRestaurant(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Optional<Restaurant> restaurant = restaurantService.findById(id);

        return restaurant.isPresent() ? ResponseEntity.ok(restaurant.get()) : ResponseEntity.notFound().build();
    }




}
