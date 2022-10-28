package com.example.Restaurants.dto;

import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


public class UserRequest {

    private Users users;

    public UserRequest() {
    }

    public UserRequest(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Restaurant> saveRestaurant(Users users) {
         users.setRestaurants(users.getRestaurants());
         return users.getRestaurants();
    }
}
