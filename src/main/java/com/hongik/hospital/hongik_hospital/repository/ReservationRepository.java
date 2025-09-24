package com.hongik.hospital.hongik_hospital.repository;
import com.hongik.hospital.hongik_hospital.domain.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final EntityManager em;

    public void save(Reservation reservation) {
        if (reservation.getId() == null) {
            em.persist(reservation);
        }
        else
        {
            em.merge(reservation);
        }
    }

    public Reservation findOne(Long reservationId) {
        return em.find(Reservation.class, reservationId);
    }
}
