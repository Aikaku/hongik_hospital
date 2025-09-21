package com.hongik.hospital.hongik_hospital.repository;

import com.hongik.hospital.hongik_hospital.domain.Department;
import com.hongik.hospital.hongik_hospital.domain.Hospital;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DepartmentRepository {

    private final EntityManager em;

    public void save(Department department){
        em.persist(department);
    }

    public Department findOne(Long id) { return em.find(Department.class, id);}
}
