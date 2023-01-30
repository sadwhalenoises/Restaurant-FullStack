package com.example.Restaurants.Service;


import com.example.Restaurants.Dao.RestaurantDao;
import com.example.Restaurants.Dao.UsersDao;
import com.example.Restaurants.Dao.pdfDao;
import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Entity.Users;
import com.example.Restaurants.Entity.pdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class pdfStorage {
    @Autowired
    private pdfDao dao;

    @Autowired
    private UsersDao usersDao;

    public pdf store(MultipartFile file, String id) throws IOException {
        String pdfName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Restaurant rest;

        Optional<Users> u = this.usersDao.findById(Integer.valueOf(id));
        Users users = null;
        if(u.isPresent()){
            users = u.get();
        } else {
            throw new RuntimeException("User not found!");
        }

        rest = users.getRestaurants().get(users.getRestaurants().size()-1);
        pdf pdf = new pdf(pdfName, file.getContentType(), file.getBytes(), rest);

        return dao.save(pdf);
    }

    public pdf getFile(String id) {
        return dao.findById(id).get();
    }

    public Stream<pdf> getAllFiles() {
        return dao.findAll().stream();
    }
}
