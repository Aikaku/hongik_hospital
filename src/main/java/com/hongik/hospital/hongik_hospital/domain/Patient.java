package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    private int id;

    private String name;

    private int age;

    private char gender;

    private Doctor doctor;
}
