package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {

    @Id
    private int id;

    private String name;

    private String number;
}
