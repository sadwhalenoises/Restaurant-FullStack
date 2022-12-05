package com.example.Restaurants.Service;

import com.example.Restaurants.Dao.RestaurantDao;
import com.example.Restaurants.Dao.UsersDao;
import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Entity.Users;
import com.example.Restaurants.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UsersDao dao;
    @Autowired
    RestaurantDao restDao;

    public Users getUserId(int id){
        Optional<Users> u = this.dao.findById(id);
        Users users = null;
        if(u.isPresent()){
            users = u.get();
        } else {
            throw new RuntimeException("User not found!");
        }

        return users;
    }

    public Users updateRestaurant(int id, Restaurant restaurant ){
        Optional<Users> u = this.dao.findById(id);
        Users users = null;
        if(u.isPresent()){
            users = u.get();
        } else {
            throw new RuntimeException("User not found!");
        }


         restDao.save(restaurant);
         users.getRestaurants().add(restaurant);
         return this.dao.save(users);

    }

    public Users addUser(Users users){
        return this.dao.save(users);
    }



//    public List<Restaurant> saveRestaurant(UserRequest request){
//        user = request.getUsers();
//        List<Restaurant> restaurant = user.getRestaurants();
//    }
}
