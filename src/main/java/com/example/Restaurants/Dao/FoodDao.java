package com.example.Restaurants.Dao;

import com.example.Restaurants.Entity.Food;
import com.example.Restaurants.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDao extends JpaRepository<Food, Integer> {
}
