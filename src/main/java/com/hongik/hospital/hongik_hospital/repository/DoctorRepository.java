package com.hongik.hospital.hongik_hospital.repository;

import com.hongik.hospital.hongik_hospital.domain.Doctor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepository {

    private EntityManager em;

    public void save(Doctor doctor) {
        em.persist(doctor);
    }
}
