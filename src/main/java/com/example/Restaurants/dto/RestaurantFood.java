package com.example.Restaurants.dto;

import com.example.Restaurants.Entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RestaurantFood {

    private Restaurant restaurant;
}
