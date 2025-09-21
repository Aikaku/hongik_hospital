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

    // 환자는 자신이 원하는 병원의 모든 정보를 제공 받을 수 있다.


    // 병원 예약 (하나의 예약만 가능)
    public void reservation(Patient patient){

    }
}
