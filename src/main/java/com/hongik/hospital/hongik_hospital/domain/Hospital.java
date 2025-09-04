package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hospital {

    @Id
    private int id;

    private String name;

    @Embedded
    private Address address;
}
