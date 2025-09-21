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

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private ReserveStatus status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDateTime reserveTime;
}
