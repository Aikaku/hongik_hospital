package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Setter
@Getter
// 특정 병원에 소속되어 있는 의사 리스트
public class HospitalDoctor {

    @Id @GeneratedValue
    @Column(name = "hospital_doctor_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "doctor_id", nullable=false, unique=true)
    // 중복 불가, NULL 불가
    private Doctor doctor;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "hospital_id", nullable=false, unique=true)
    // 중복 불가, NULL 불가
    private Hospital hospital;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "hospital_department_id", nullable=false, unique=true)
    // 중복 불가, NULL 불가
    private HospitalDepartment hospitalDepartment;

    @OneToMany(mappedBy = "hospitalDoctor", cascade = CascadeType.ALL)
    private List<Patient> patients = new ArrayList<>();

    @OneToMany (mappedBy = "hospitalDoctor", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    //=====연관 관계 메서드=====//
    public void addPatient(Patient patient) {
        patients.add(patient);
        patient.setHospitalDoctor(this);
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
        reservation.setHospitalDoctor(this);
    }
}
