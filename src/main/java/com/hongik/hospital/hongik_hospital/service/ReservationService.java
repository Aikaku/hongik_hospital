package com.hongik.hospital.hongik_hospital.service;

import com.hongik.hospital.hongik_hospital.domain.Doctor;
import com.hongik.hospital.hongik_hospital.domain.Patient;
import com.hongik.hospital.hongik_hospital.domain.Reservation;
import com.hongik.hospital.hongik_hospital.domain.ReserveStatus;
import com.hongik.hospital.hongik_hospital.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;

    // 예약 조회
    public Reservation findReservation(Long reservationId) {
        return reservationRepository.findOne(reservationId);
    }

    // 예약
    //  → 환자가 특정 의사에게 진료 예약 생성
    //  → 제약 조건: 환자는 같은 의사에 대해 1개의 예약만 가능
    public void reserve(Long patientId, Long doctorId, LocalDateTime when) {
        Patient patient = patientService.findPatient(patientId);
        Doctor doctor = doctorService.findDoctor(doctorId);

        Reservation reservation = Reservation.createReservation(patient, doctor, when);

        reservationRepository.save(reservation);
    }

    // 예약 취소
    public void cancel(Long reservationId) {
        Reservation reservation = findReservation(reservationId);
        reservation.cancel();
    }

    // 예약 진료 완료
    public void completeReservation(Long reservationId) {
        Reservation reservation = findReservation(reservationId);
        reservation.complete();
    }
}
