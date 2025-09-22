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

    //=====생성 메서드=====//

    public static Reservation createReservation(Patient patient, Doctor doctor, LocalDateTime when) {
        Reservation reservation = new Reservation();

        reservation.setStatus(ReserveStatus.RESERVE);
        reservation.setPatient(patient);
        reservation.setDoctor(doctor);
        reservation.setReserveTime(when);

        return reservation;
    }

    //=====비지니스 로직=====//
    public void cancel() {
        if (this.getStatus() == ReserveStatus.COMP) {
            throw new IllegalStateException("이미 진료가 완료된 예약입니다.");
        }
        this.setStatus(ReserveStatus.CANCEL);
    }
}
