package com.hongik.hospital.hongik_hospital.repository;

import com.hongik.hospital.hongik_hospital.domain.HospitalDepartment;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    private EntityManager em;

    public void save(HospitalDepartment hospitalDepartment){
        em.persist(hospitalDepartment);
    }
}
