package com.example.Restaurants.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Food")
public class Food {



    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Id
    private String foodType;

    private int foodName;

    private double foodPrice;

    public Food(String foodType, int foodName, double foodPrice) {
        this.foodType = foodType;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getFoodName() {
        return foodName;
    }

    public void setFoodName(int foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }
}
