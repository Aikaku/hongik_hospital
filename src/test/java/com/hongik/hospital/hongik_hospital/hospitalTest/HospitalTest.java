package com.hongik.hospital.hongik_hospital.hospitalTest;

import com.hongik.hospital.hongik_hospital.domain.Address;
import com.hongik.hospital.hongik_hospital.domain.Hospital;
import com.hongik.hospital.hongik_hospital.repository.HospitalRepository;
import com.hongik.hospital.hongik_hospital.service.HospitalService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class HospitalTest {

    EntityManager em;

    @Autowired
    HospitalService hospitalService;

    @Autowired
    HospitalRepository hospitalRepository;

    @Transactional
    @Rollback(value = false)
    @Test
    public void createHospitalTest() throws Exception {
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
    }
}
