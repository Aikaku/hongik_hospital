package com.hongik.hospital.hongik_hospital.repository;

import com.hongik.hospital.hongik_hospital.domain.Doctor;
import com.hongik.hospital.hongik_hospital.domain.Hospital;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoctorRepository {

    private final EntityManager em;

    // 의사 등록 및 수정
    public void save(Doctor doctor){
        if (doctor.getId() == null) {
            em.persist(doctor);
        }
        else {
            em.merge(doctor);
        }
    }

    // 의사 조회
    public Doctor findOne(Long id) { return em.find(Doctor.class, id);}

    // 부서의 의사 전체 조회
    public List<Doctor> findAllOfDepartment(Long hospitalDepartmentId) {
        return em.createQuery("select d from Doctor d where d.hospitalDepartment.id = :HospitalDepartmentId"
                        , Doctor.class)
                .setParameter("HospitalDepartmentId", hospitalDepartmentId).getResultList();
    }
}
