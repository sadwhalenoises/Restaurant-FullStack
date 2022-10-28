package com.example.Restaurants.Service;

import com.example.Restaurants.Dao.FoodDao;
import com.example.Restaurants.Dao.RestaurantDao;
import com.example.Restaurants.Entity.Food;
import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    FoodDao dao;
    @Autowired
    RestaurantDao restDao;

    public List<Food> getFood() { return dao.findAll();}


    public Food updateFood(Food food) { return this.dao.save(food);}

    public String removeFood(int id){
        this.dao.deleteById(id);
        return "Deleted!";
    }

    public Restaurant addFood(int id, Food food){
        Optional<Restaurant> r = this.restDao.findById(id);
        Restaurant restaurant = null;
        if(r.isPresent()){
            restaurant = r.get();
        } else {
            throw new RuntimeException("Restaurant not found!");
        }
        this.dao.save(food);
        restaurant.getRestFood().add(food);
        return this.restDao.save(restaurant);

    }

}
