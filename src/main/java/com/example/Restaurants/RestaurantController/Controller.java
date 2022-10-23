package com.example.Restaurants.RestaurantController;

import com.example.Restaurants.Entity.Food;
import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Service.FoodService;
import com.example.Restaurants.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private FoodService foodService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/Restaurant")
    public List<Restaurant> getRestaurants(){return this.restaurantService.getRestaurants();}

    @GetMapping("/Restaurant/{id}")
    public Restaurant getId(@PathVariable String id) {return this.restaurantService.getRestaurantId(Integer.parseInt(id));}

    @PostMapping("/Restaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){return this.restaurantService.addRestaurant(restaurant);}

    @PutMapping("/Restaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){return this.restaurantService.updateRestaurant(restaurant);}

    @DeleteMapping("/Restaurant/{id}")
    public String removeRestaurant(@PathVariable String id){
        return this.restaurantService.removeRestaurant(Integer.parseInt(id));
    }

    @GetMapping("/Food")
    public List<Food> getFood(){return this.foodService.getFood();}

    @PostMapping("/Food")
    public Food addFood(@RequestBody Food food){return this.foodService.addFood(food);}

    @PutMapping("/Food")
    public Food updateFood(@RequestBody Food food){return this.foodService.updateFood(food);}

    @DeleteMapping("/Food/{id}")
    public String removeFood(@PathVariable String id){
        return this.foodService.removeFood(Integer.parseInt(id));
    }

}
