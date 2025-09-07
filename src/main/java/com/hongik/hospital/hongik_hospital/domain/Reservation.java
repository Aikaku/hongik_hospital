package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Reservation {

    @Id @GeneratedValue
    @Column(name = "reserve_id")
    private Long id;

    @Enumerated
    private ReserveStatus status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "hospital_doctor_id")
    private HospitalDoctor hospitalDoctor;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "hospital_department_id")
    private HospitalDepartment hospitalDepartment;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime reserveTime;

    //=====비지니스 로직 메서드=====//
}
