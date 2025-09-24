package com.hongik.hospital.hongik_hospital.repository;

import com.hongik.hospital.hongik_hospital.domain.Department;
import com.hongik.hospital.hongik_hospital.domain.Hospital;
import com.hongik.hospital.hongik_hospital.domain.HospitalDepartment;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DepartmentRepository {

    private final EntityManager em;

    public void save(Department department){
        em.persist(department);
    }

    public Department findOne(Long id) { return em.find(Department.class, id);}

    public List<HospitalDepartment> findAllOfHospital(Long hospitalId) {
        return em.createQuery("select h from HospitalDepartment h where h.hospital.id = :hospitalId"
                , HospitalDepartment.class).setParameter("hospitalId",hospitalId).getResultList();
    }
}
