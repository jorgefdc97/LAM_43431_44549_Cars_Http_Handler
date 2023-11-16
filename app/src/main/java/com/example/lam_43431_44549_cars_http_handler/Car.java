package com.example.lam_43431_44549_cars_http_handler;

public class Car {

    private final String name;
    private final int logo;

    public Car(String name, int logo){
        this.name = name;
        this.logo = logo;
    }

    public String getName() {
        return this.name;
    }

    public int getLogo() {
        return logo;
    }
}