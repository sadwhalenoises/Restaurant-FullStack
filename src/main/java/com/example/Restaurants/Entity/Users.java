package com.example.Restaurants.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String email;

    private String password;

    @OneToMany(targetEntity = Restaurant.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name ="restaurant_id", referencedColumnName = "id")
    private List<Restaurant> restaurants;


}
