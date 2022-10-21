package com.example.Restaurants.Dao;

import com.example.Restaurants.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDao extends JpaRepository<Food, Integer> {
}
