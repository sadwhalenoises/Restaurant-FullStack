package com.example.Restaurants.Dao;

import com.example.Restaurants.Entity.pdf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pdfDao extends JpaRepository<pdf, String> {
}
