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
    @Enumerated
    // 중복 가능, NULL 불가
    private Gender gender;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "doctor_id")
    // 없으면 doctor_doctor_id가 patient table에 생성되나
    // 해당 어노테이션을 쓰면 doctor_id가 됌
    // 중복 가능
    private HospitalDoctor hospitalDoctor;

    @OneToMany (mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    //=====연관 관계 메서드=====//

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
        reservation.setPatient(this);
    }
}
