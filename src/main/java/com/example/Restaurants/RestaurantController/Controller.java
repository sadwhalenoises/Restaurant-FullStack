package com.example.Restaurants.RestaurantController;

import com.example.Restaurants.Dao.FoodDao;
import com.example.Restaurants.Dao.RestaurantDao;
import com.example.Restaurants.Dao.UsersDao;
import com.example.Restaurants.Entity.Food;
import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Entity.Users;
import com.example.Restaurants.Service.FoodService;
import com.example.Restaurants.Service.RestaurantService;
import com.example.Restaurants.Service.UserService;
import com.example.Restaurants.dto.RestaurantFood;
import com.example.Restaurants.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodDao foodDao;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private RestaurantDao restDao;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @GetMapping("/Restaurant")
    public List<Restaurant> getRestaurants(){return this.restaurantService.getRestaurants();}

    @GetMapping("/Restaurant/{id}")
    public Restaurant getId(@PathVariable String id) {return this.restaurantService.getRestaurantId(Integer.parseInt(id));}

    @PostMapping("/Restaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){return this.restaurantService.addRestaurant(restaurant);}

    @PostMapping("/RestaurantTest") //food
    public Restaurant addFood(@RequestBody RestaurantFood restaurantFood){
        return restDao.save(restaurantFood.getRestaurant());
    }

    @GetMapping("/getRestaurant") //food
    public List<Restaurant> findAllRestaurants(){
        return restDao.findAll();
    }

    @PostMapping("/createrestaurant")
    public Users addRest(@RequestBody UserRequest request){
        return usersDao.save(request.getUsers());
    }

    @PostMapping("/addrestaurant/{id}")
    public Users updateRest(@PathVariable int id, @RequestBody Restaurant restaurant){
        return this.userService.updateRestaurant(id, restaurant);
    }

    @GetMapping("/getTest")
    public List<Users> findAllUsers(){
        return usersDao.findAll();
    }

    @PutMapping("/Restaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){return this.restaurantService.updateRestaurant(restaurant);}

    @DeleteMapping("/Restaurant/{id}")
    public String removeRestaurant(@PathVariable String id){
        return this.restaurantService.removeRestaurant(Integer.parseInt(id));
    }

    @GetMapping("/Food")
    public List<Food> getFood(){return this.foodService.getFood();}


    @PostMapping("/Food/{id}")
    public Restaurant addFood(@PathVariable int id, @RequestBody Food food){return this.foodService.addFood(id,food);}

    @PutMapping("/Food")
    public Food updateFood(@RequestBody Food food){return this.foodService.updateFood(food);}

    @DeleteMapping("/Food/{id}")
    public String removeFood(@PathVariable String id){
        return this.foodService.removeFood(Integer.parseInt(id));
    }

}
