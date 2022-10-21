package com.example.Restaurants.Service;


import com.example.Restaurants.Dao.RestaurantDao;
import com.example.Restaurants.Dao.pdfDao;
import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Entity.pdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class pdfStorage {
    @Autowired
    private pdfDao dao;

    public pdf store(MultipartFile file, String id) throws IOException {
        String pdfName = StringUtils.cleanPath(file.getOriginalFilename());
        pdf pdf = new pdf(pdfName, file.getContentType(), file.getBytes());

        return dao.save(pdf);
    }

    public pdf getFile(String id) {
        return dao.findById(id).get();
    }

    public Stream<pdf> getAllFiles() {
        return dao.findAll().stream();
    }
}
