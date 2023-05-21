package com.cars.models;

public class CarForSearchBuilder {
    private String newUsed;
    private String make;
    private String model;
    private String price;
    private String distance;
    private String zip;

    public CarForSearchBuilder setNewUsed(String newUsed) {
        this.newUsed = newUsed;
        return this;
    }

    public CarForSearchBuilder setMake(String make) {
        this.make = make;
        return this;
    }

    public CarForSearchBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CarForSearchBuilder setPrice(String price) {
        this.price = price;
        return this;
    }

    public CarForSearchBuilder setDistance(String distance) {
        this.distance = distance;
        return this;
    }

    public CarForSearchBuilder setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public CarForSearch build() {
        return new CarForSearch(newUsed, make, model, price, distance, zip);
    }
}
