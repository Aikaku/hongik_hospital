package com.hongik.hospital.hongik_hospital.repository;

import com.hongik.hospital.hongik_hospital.domain.Patient;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
public class PatientRepository {

    private EntityManager em;

    public void save(Patient patient){ em.persist(patient); }
}
