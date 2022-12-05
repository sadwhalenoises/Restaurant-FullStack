package com.example.Restaurants.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Resturants")
public class Restaurant {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int restaurantId;

    @Column(name="name")
    private String restaurantName;

    @Lob
    private byte[] pdf;

    @OneToMany(targetEntity = Food.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "r_id", referencedColumnName = "Id")
    private List<Food> restFood;

//    @OneToMany(targetEntity =pdf.class, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "restaurant_id", referencedColumnName = "Id")
//    private List<pdf> pdfFiles;
}
