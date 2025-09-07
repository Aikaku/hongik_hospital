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
}
