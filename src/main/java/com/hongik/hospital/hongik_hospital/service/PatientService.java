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

    private final PatientRepository patientRepository;

    // 환자 등록
    public Long registerPatient(Patient patient){
        patientRepository.save(patient);
        return patient.getId();
    }

    // 환자 조회
    public Patient findPatient(Long patientId) {
        return patientRepository.findOne(patientId);
    }
}
