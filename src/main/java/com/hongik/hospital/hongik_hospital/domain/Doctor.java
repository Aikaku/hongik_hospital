package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Doctor {

    @Id
    private int id;

    private String name;

    private int personal_history;

    private Hospital hospital;

    private Department department;
}
