package com.example.Restaurants.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Resturants")
public class Restaurant {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String resturantId;

    @Column(name="name")
    private String restaurantName;

    @Lob
    private byte[] pdf;

    public Restaurant(){

    }

    public Restaurant(String restaurantName, byte[] pdf) {
        this.restaurantName = restaurantName;
        this.pdf = pdf;
    }

    public String getResturantId() {
        return resturantId;
    }

    public void setResturantId(String resturantId) {
        this.resturantId = resturantId;
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
}
