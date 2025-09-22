package com.hongik.hospital.hongik_hospital.repository;

import com.hongik.hospital.hongik_hospital.domain.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PatientRepository {

    private final EntityManager em;

    public void save(Patient patient){ em.persist(patient); }

    public Patient findOne(Long patientId) { return em.find(Patient.class, patientId); }

    public List<Patient> findPatientOfDoctor(Long reservationId) {
        return em.createQuery("select p from Patient p where p.reservations.id =: ReservationId"
                , Patient.class).setParameter("ReservationId", reservationId).getResultList();
    }

}
