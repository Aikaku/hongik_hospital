package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Setter
@Getter
// 존재하는 모든 부서 리스트
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "depatrtment_id", nullable=false)
    // 중복 불가, NULL 불가
    private Long id;

    // 중복 불가, NULL 불가
    @Column(nullable=false, unique=true)
    private String name;

    @OneToMany (mappedBy = "department", cascade = CascadeType.ALL)
    private List<HospitalDepartment> hds = new ArrayList<>();

    @OneToMany (mappedBy = "department", cascade = CascadeType.ALL)
    private List<Doctor> doctors = new ArrayList<>();
}
