package com.hongik.hospital.hongik_hospital.repository;

import com.hongik.hospital.hongik_hospital.domain.Hospital;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository {

    private EntityManager em;

    public void save(Hospital hospital){
        em.persist(hospital);
    }

    // 병원 리스트 조회

    // 특정 병원의 부서 리스트 조회

    // 특정 병원 부서의 의사 리스트 조회
}
