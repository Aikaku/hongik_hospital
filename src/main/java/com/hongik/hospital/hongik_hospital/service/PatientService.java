package com.hongik.hospital.hongik_hospital.service;

import com.hongik.hospital.hongik_hospital.domain.Patient;
import com.hongik.hospital.hongik_hospital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    private PatientRepository patientRepository;

    // 병원의 회원 등록
    public Long registerPatient(Patient patient){
        patientRepository.save(patient);
        return patient.getId();
    }

    // 특정 병원의 이름, 주소, 진료과 조회

    // 특정 병원의 의사 조회

    // 병원 예약 (하나의 예약만 가능)
    public void resercation(Patient patient){

    }
}
