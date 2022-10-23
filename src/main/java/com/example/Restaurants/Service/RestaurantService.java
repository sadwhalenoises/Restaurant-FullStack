package com.example.Restaurants.Service;

import com.example.Restaurants.Dao.RestaurantDao;
import com.example.Restaurants.Entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantDao dao;

    public List<Restaurant> getRestaurants(){ return dao.findAll();}

    public Restaurant getRestaurantId(String id) {

        Optional<Restaurant> r = this.dao.findById(id);
        Restaurant restaurant = null;
        if(r.isPresent()){
            restaurant = r.get();
        } else {
            throw new RuntimeException("Restaurant not found!");
        }

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant){ return this.dao.save(restaurant);}

    public Restaurant updateRestaurant(Restaurant restaurant) { return this.dao.save(restaurant); }

    public String removeRestaurant(String id){
        this.dao.deleteById(id);
        return "Deleted!";
    }

}
