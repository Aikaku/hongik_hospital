package com.hongik.hospital.hongik_hospital.service;

import com.hongik.hospital.hongik_hospital.domain.Department;
import com.hongik.hospital.hongik_hospital.domain.Hospital;
import com.hongik.hospital.hongik_hospital.domain.HospitalDepartment;
import com.hongik.hospital.hongik_hospital.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    // 부서 등록
    public void registerDepartment(Department department ){
        departmentRepository.save(department);
    }

    // 부서 조회
    public Department findDepartment(Long departmentId) {
        return departmentRepository.findOne(departmentId);
    }

    public List<HospitalDepartment> findHospitalDepartmentOfHospital (Long hospitalId) {
        return departmentRepository.findAllOfHospital(hospitalId);
    }
}
