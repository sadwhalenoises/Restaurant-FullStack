package com.example.Restaurants.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class pdf {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    public pdf() {

    }

    public pdf(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public pdf(String name, String type, byte[] data, Restaurant restaurant) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.restaurant = restaurant;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "restId", referencedColumnName = "Id")
    private Restaurant restaurant;
}
