package com.example.Restaurants.Service;

import com.example.Restaurants.Dao.FoodDao;
import com.example.Restaurants.Entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    FoodDao dao;

    public List<Food> getFood() { return dao.findAll();}

    public Food addFood(Food food) { return this.dao.save(food);}

    public Food updateFood(Food food) { return this.dao.save(food);}

    public String removeFood(int id){
        this.dao.deleteById(id);
        return "Deleted!";
    }

}
