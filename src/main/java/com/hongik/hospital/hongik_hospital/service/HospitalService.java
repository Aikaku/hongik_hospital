package com.hongik.hospital.hongik_hospital.service;

import com.hongik.hospital.hongik_hospital.domain.Hospital;
import com.hongik.hospital.hongik_hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    // 신규 병원 등록
    public void newHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }

    // 병원 리스트 조회

    // 병원의 부서 리스트 조회

    // 병원의 의사 리스트 조회

    // 병원 특정 부서의 의사 리스트 조회
}
