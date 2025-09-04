package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Patient {

    @Id @GeneratedValue
    @Column(name = "patient_id")
    private int id;

    private String name;

    private int age;

    private char gender;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "doctor_id")
    // 없으면 doctor_doctor_id가 patient table에 생성되나
    // 해당 어노테이션을 쓰면 doctor_id가 됌
    private Doctor doctor;
}
