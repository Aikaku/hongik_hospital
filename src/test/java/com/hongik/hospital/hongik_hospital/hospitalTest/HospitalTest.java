package com.hongik.hospital.hongik_hospital.hospitalTest;

import com.hongik.hospital.hongik_hospital.domain.Address;
import com.hongik.hospital.hongik_hospital.domain.Hospital;
import com.hongik.hospital.hongik_hospital.repository.HospitalRepository;
import com.hongik.hospital.hongik_hospital.service.HospitalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static com.hongik.hospital.hongik_hospital.domain.Hospital.createHospital;

@SpringBootTest
public class HospitalTest {

    @Autowired
    HospitalService hospitalService;

    @Autowired
    HospitalRepository hospitalRepository;

    @Transactional
    @Rollback(value = false)
    @Test
    public void createHospitalTest() throws Exception {
        String name = "서울 아산 병원";
        Address address = new Address("123", "아산시", "분당로");

        Hospital hospital = new Hospital();

        // hospital.setId(1L);
        hospital.setName(name);
        hospital.setAddress(address);

        // hospitalService.newHospital(hospital);
        hospitalRepository.save(hospital);
    }
}
