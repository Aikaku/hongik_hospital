package com.hongik.hospital.hongik_hospital.service;

import com.hongik.hospital.hongik_hospital.domain.Doctor;
import com.hongik.hospital.hongik_hospital.domain.Hospital;
import com.hongik.hospital.hongik_hospital.domain.HospitalDepartment;
import com.hongik.hospital.hongik_hospital.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final DepartmentService departmentService;
    private final DoctorService doctorService;

    // 병원 등록
    public void registerHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }

    // 병원 조회
    public Hospital findHospital(Long hospitalId) {
        return hospitalRepository.findOne(hospitalId);
    }

    // 환자는 자신이 원하는 병원의 모든 정보를 제공 받을 수 있다.
    public void viewInformation(Long hospitalId) {
        Hospital hospital = hospitalRepository.findOne(hospitalId);
        if(hospital == null) {
            throw new IllegalStateException("병원이 없습니다.");
        }

        System.out.println("병원 : " + hospital.getName() +
                " | 주소 : " + hospital.getAddress().toString());

        List<HospitalDepartment> hds = departmentService.findHospitalDepartmentOfHospital(hospitalId);

        for ( HospitalDepartment hospitalDepartment : hds) {

            List<Doctor> doctors = doctorService.findDoctorsOfDepartment(hospitalDepartment.getId());
            System.out.println("=====" + hospitalDepartment.getDepartment().getName() + "=====");

            for(Doctor doctor : doctors) {

                System.out.println("이름 : " + doctor.getName() + " | 경력 : " + doctor.getPersonal_history());
            }
        }
    }
}
