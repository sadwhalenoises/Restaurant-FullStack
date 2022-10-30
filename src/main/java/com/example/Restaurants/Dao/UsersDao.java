package com.example.Restaurants.Dao;

import com.example.Restaurants.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {
        List<Users> findByName(String name);
        List<Users> findByEmail(String name);
}
