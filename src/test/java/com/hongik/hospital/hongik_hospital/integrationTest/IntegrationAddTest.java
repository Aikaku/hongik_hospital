package com.hongik.hospital.hongik_hospital.integrationTest;

import com.hongik.hospital.hongik_hospital.domain.Address;
import com.hongik.hospital.hongik_hospital.domain.Department;
import com.hongik.hospital.hongik_hospital.domain.Hospital;
import com.hongik.hospital.hongik_hospital.repository.DepartmentRepository;
import com.hongik.hospital.hongik_hospital.repository.HospitalRepository;
import com.hongik.hospital.hongik_hospital.service.HospitalService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class IntegrationAddTest {

    EntityManager em;

    @Autowired
    HospitalService hospitalService;

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    @Test
    @Transactional
    @Rollback(value = false)
    public void createOneToOneHospitalTest() {
        Hospital hospital1 = new Hospital();
        Hospital hospital2 = new Hospital();
        Hospital hospital3 = new Hospital();

        hospital1.setName("서울 아산 병원");
        Address address1 = new Address("111", "서울시", "송파구");
        hospital1.setAddress(address1);

        hospital2.setName("일산 백병원");
        Address address2 = new Address("222", "고양시", "덕양구");
        hospital2.setAddress(address2);

        hospital3.setName("신천 연합 병원");
        Address address3 = new Address("333", "시흥시", "신천동");
        hospital3.setAddress(address3);

        hospitalRepository.save(hospital1);
        hospitalRepository.save(hospital2);
        hospitalRepository.save(hospital3);

        //-----여기까지 병원 추가-----//

        Department department1 = new Department();
        Department department2 = new Department();
        Department department3 = new Department();

        department1.setName("비뇨기과");
        department2.setName("산부인과");
        department3.setName("내과");

        departmentRepository.save(department1);
        departmentRepository.save(department2);
        departmentRepository.save(department3);

        //-----여기까지 부서 추가-----//

        hospital1.addDepartment(department1);
        hospital1.addDepartment(department2);
        hospital1.addDepartment(department3);

        hospital2.addDepartment(department1);
        hospital2.addDepartment(department2);

        //-----------------------------//
        // 비1 1 서울1
        // 산2 1 서울1
        // 내3 1 서울1
        // 비1 2 일산2
        // 산2 2 일산2
        //-----------------------------//


        //-----여기까지 병원에 부서 추가-----//
    }
}
