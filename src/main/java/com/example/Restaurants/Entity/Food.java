package com.example.Restaurants.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Food")
public class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String foodType;

    private String foodName;

    private double foodPrice;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Restaurant_id", insertable = false, updatable = false, referencedColumnName = "id")
//    @Fetch(FetchMode.JOIN)
//    private List<Restaurant> restaurant;

}
