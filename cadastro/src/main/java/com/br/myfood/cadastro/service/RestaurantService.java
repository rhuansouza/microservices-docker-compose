package com.br.myfood.cadastro.service;

import com.br.myfood.cadastro.entity.Restaurant;
import com.br.myfood.cadastro.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant insertRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Restaurant restaurant){
        Optional<Restaurant> newRestaurant = restaurantRepository.findById(restaurant.getId());
        if(newRestaurant.isPresent()){
            return restaurantRepository.save(restaurant);
        }
        return null;
    }

    public boolean deleteRestaurant(Long id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        if(restaurant.isPresent()){
            restaurantRepository.delete(restaurant.get());
            return true;
        }else{
            return false;
        }
    }

    public Optional<Restaurant> findById(Long id){
        return restaurantRepository.findById(id);
    }



}
