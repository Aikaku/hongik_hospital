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
public class Patient {

    @Id @GeneratedValue
    @Column(name = "patient_id")
    private Long id;

    @Column(nullable=false)
    // 중복 가능, NULL 불가
    private String name;

    @Column(nullable=false)
    // 중복 가능, NULL 불가
    private int age;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    // 중복 가능, NULL 불가
    private Gender gender;

    @OneToMany (mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    //=====연관 관계 메서드=====//

    public void addReservation(Doctor doctor) {
        Reservation reservation = new Reservation();
        reservation.setDoctor(doctor);
        reservation.setPatient(this);
        this.reservations.add(reservation);
        doctor.getReservationList().add(reservation);
    }
}
