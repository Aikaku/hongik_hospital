package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String country;

    private String city;

    private String street;
}
