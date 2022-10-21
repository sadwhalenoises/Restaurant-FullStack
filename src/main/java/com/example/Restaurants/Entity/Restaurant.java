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
    private String resturantName;

    @Lob
    private byte[] pdf;

    public Restaurant(){

    }

    public Restaurant(String resturantId, String resturantName, byte[] pdf) {
        this.resturantId = resturantId;
        this.resturantName = resturantName;
        this.pdf = pdf;
    }

    public String getResturantId() {
        return resturantId;
    }

    public void setResturantId(String resturantId) {
        this.resturantId = resturantId;
    }

    public String getResturantName() {
        return resturantName;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }
}
