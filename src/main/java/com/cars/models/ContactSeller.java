package com.cars.models;

public class ContactSeller {

    private String firstName;
    private String lastName;
    private String email;

    public ContactSeller(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
