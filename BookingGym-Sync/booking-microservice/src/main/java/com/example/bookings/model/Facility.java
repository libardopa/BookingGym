package com.example.bookings.model;

import java.io.Serializable;

public class Facility implements Serializable {
    private Long id;
    private String address;
    private String city;

    public Facility(Long id, String address, String city) {
        this.id = id;
        this.address = address;
        this.city = city;
    }
    public Facility(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
