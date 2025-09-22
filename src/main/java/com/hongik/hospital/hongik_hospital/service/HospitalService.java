package com.hongik.hospital.hongik_hospital.service;

import com.hongik.hospital.hongik_hospital.domain.Hospital;
import com.hongik.hospital.hongik_hospital.repository.HospitalRepository;
import com.hongik.hospital.hongik_hospital.repository.PatientRepository;
import com.hongik.hospital.hongik_hospital.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final PatientRepository patientRepository;
    private final ReservationRepository reservationRepository;

    // 신규 병원 등록
    public void newHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }

    // 병원은 해당 병원의 모든 환자를 조회할 수 있어야 한다.
    public void viewAllPatient(Long hospitalId) {
        Hospital hospital = hospitalRepository.findOne(hospitalId);

        // 해당 병원의 모든 부서 조회
        // 부서의 의사들 조회
        // 의사의 환자 목록 조회
    }
}
