package com.hongik.hospital.hongik_hospital.repository;

import com.hongik.hospital.hongik_hospital.domain.Reservation;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveRepository {

    private EntityManager em;

    public void save(Reservation reservation) {
        em.persist(reservation);
    }
}
