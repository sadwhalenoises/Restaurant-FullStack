package com.example.Restaurants.Service;

import com.example.Restaurants.Dao.RestaurantDao;
import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Entity.pdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantDao dao;

    public List<Restaurant> getRestaurants(){ return dao.findAll();}

    public Restaurant getRestaurantId(int id) {

        Optional<Restaurant> r = this.dao.findById(id);
        Restaurant restaurant = null;
        if(r.isPresent()){
            restaurant = r.get();
        } else {
            throw new RuntimeException("Restaurant not found!");
        }

        return restaurant;
    }

    public Restaurant store(MultipartFile file, int id) throws IOException {
        Optional<Restaurant> r = this.dao.findById(id);
        Restaurant restaurant = null;
        if(r.isPresent()){
            restaurant = r.get();
        } else {
            throw new RuntimeException("Restaurant not found!");
        }

        restaurant.setPdf(file.getBytes());


        return dao.save(restaurant);
    }

    public OutputStream getPdf(int id) throws IOException {
        Optional<Restaurant> r = this.dao.findById(id);
        Restaurant restaurant = null;
        if(r.isPresent()){
            restaurant = r.get();
        } else {
            throw new RuntimeException("Restaurant not found!");
        }
        byte[] pdf = restaurant.getPdf();
        OutputStream out = new FileOutputStream("restaurant.pdf");
        out.write(pdf);
        out.close();


        return out;
    }

    public Restaurant addRestaurant(Restaurant restaurant){ return this.dao.save(restaurant);}

    public Restaurant updateRestaurant(Restaurant restaurant) { return this.dao.save(restaurant); }

    public String removeRestaurant(int id){
        this.dao.deleteById(id);
        return " ";
    }

}
