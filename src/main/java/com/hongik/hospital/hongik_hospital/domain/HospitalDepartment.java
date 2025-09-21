package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class HospitalDepartment {

    @Id
    @GeneratedValue
    @Column(name = "hospital_department_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne (fetch = LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @OneToMany (mappedBy = "hospitalDepartment", cascade = CascadeType.ALL)
    private List<Doctor> doctorList = new ArrayList<>();
}
