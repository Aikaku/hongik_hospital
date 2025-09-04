package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String zipcode;

    private String city;

    private String street;

    protected Address() { }

    public Address(String zipcode, String city, String street) {
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
    }
}
