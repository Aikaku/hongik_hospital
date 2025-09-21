package com.hongik.hospital.hongik_hospital.departmentTest;

import com.hongik.hospital.hongik_hospital.domain.Department;
import com.hongik.hospital.hongik_hospital.repository.HospitalRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class DepartmentTest {

    EntityManager em;

    @Autowired
    HospitalRepository hospitalRepository;

    @Transactional
    @Rollback(value = false)
    @Test
    public void createDepartmentTest() throws Exception {
        Department department1 = new Department();
        Department department2 = new Department();
        Department department3 = new Department();

        department1.setName("비뇨기과");
        department2.setName("산부인과");
        department3.setName("내과");
    }
}
