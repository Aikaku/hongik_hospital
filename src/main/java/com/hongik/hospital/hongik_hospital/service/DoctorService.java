package com.hongik.hospital.hongik_hospital.service;

import com.hongik.hospital.hongik_hospital.domain.Doctor;
import com.hongik.hospital.hongik_hospital.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    // 의사 등록
    public void registerDoctor(Doctor doctor) { doctorRepository.save(doctor); }

    // 의사 정보 수정
    public void updateDoctor(Doctor doctor) { doctorRepository.save(doctor); }

    // 의사 조회
    public Doctor findDoctor(Long doctorId) {
        return doctorRepository.findOne(doctorId);
    }

    // 부서의 의사 목록 조회
    public List<Doctor> findDoctorsOfDepartment(Long hospitalDepartmentId) {
        return doctorRepository.findAllOfDepartment(hospitalDepartmentId);
    }
}
