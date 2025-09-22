package com.hongik.hospital.hongik_hospital.service;

import com.hongik.hospital.hongik_hospital.domain.*;
import com.hongik.hospital.hongik_hospital.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;
    private final HospitalRepository hospitalRepository;
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    // 환자 등록
    public Long registerPatient(Patient patient){
        patientRepository.save(patient);
        return patient.getId();
    }

    // 병원의 환자 찾기
    public Patient findPatient(Long patientId) {
        return patientRepository.findOne(patientId);
    }

    // 병원의 의사 찾기
    public Doctor findDoctor(Long doctorId) {
        return doctorRepository.findOne(doctorId);
    }

    // 예약 찾기
    public Reservation findReservation(Long reservationId) {
        return reservationRepository.findOne(reservationId);
    }

    // 환자는 자신이 원하는 병원의 모든 정보를 제공 받을 수 있다.
    public void viewInformation(Long hospitalId) {
        Hospital hospital = hospitalRepository.findOne(hospitalId);
        if(hospital == null) {
            throw new IllegalStateException("병원이 없습니다.");
        }

        System.out.println("병원 : " + hospital.getName() +
                " | 주소 : " + hospital.getAddress().toString());

        List<HospitalDepartment> hds = departmentRepository.findHospitalDepartmentOfHospital(hospitalId);

        for ( HospitalDepartment hospitalDepartment : hds) {

            List<Doctor> doctors = doctorRepository.findDoctorOfDepartment(hospitalDepartment.getId());
            System.out.println("=====" + hospitalDepartment.getDepartment().getName() + "=====");

            for(Doctor doctor : doctors) {

                System.out.println("이름 : " + doctor.getName() + " | 경력 : " + doctor.getPersonal_history());
            }
        }
    }

    // 환자는 병원을 예약할 수 있다. (하나의 예약만 가능)
    public void reserve(Long patientId, Long doctorId, LocalDateTime when){
        Patient patient = findPatient(patientId);
        Doctor doctor = findDoctor(doctorId);

        Reservation reservation = Reservation.createReservation(patient, doctor, when);

        reservationRepository.save(reservation);
    }

    // 환자는 예약을 취소할 수 있다.
    public void cancel(Long reservationId) {
        Reservation reservation = findReservation(reservationId);
        reservation.cancel();
    }
}
