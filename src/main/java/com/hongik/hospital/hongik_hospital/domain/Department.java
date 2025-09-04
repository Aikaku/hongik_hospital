package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Department {

    @Id @GeneratedValue
    @Column(name = "depatrtment_id")
    private int id;

    private String name;

    private String number;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany (mappedBy = "department", cascade = CascadeType.ALL)
    private List<Doctor> doctors = new ArrayList<>();
}
