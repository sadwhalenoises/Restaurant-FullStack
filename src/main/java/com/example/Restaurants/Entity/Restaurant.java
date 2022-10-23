package com.example.Restaurants.Entity;

import javax.persistence.*;
import java.util.Arrays;

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

    public Restaurant(){

    }

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getResturantId() {
        return restaurantId;
    }



    public String getResturantName() {
        return restaurantName;
    }

    public void setResturantName(String resturantName) {
        this.restaurantName = resturantName;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", pdf=" + Arrays.toString(pdf) +
                '}';
    }
}
