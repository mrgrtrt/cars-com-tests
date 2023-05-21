package com.cars.models;

public class CarForSearch {

    private String newUsed;
    private String make;
    private String model;
    private String price;
    private String distance;
    private String zip;

    public CarForSearch(String newUsed, String make, String model, String price, String distance, String zip) {
        this.newUsed = newUsed;
        this.make = make;
        this.model = model;
        this.price = price;
        this.distance = distance;
        this.zip = zip;
    }

    public String getNewUsed() {
        return newUsed;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }

    public String getDistance() {
        return distance;
    }

    public String getZip() {
        return zip;
    }
}
