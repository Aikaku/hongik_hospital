package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Hospital {

    @Id @GeneratedValue
    @Column(name = "hospital_id")
    // 중복 불가, NULL 불가
    private Long id;

    @Column(nullable=false, unique=true)
    // 중복 불가, NULL 불가
    private String name;

    @Embedded
    // 중복 불가, NULL 불가
    private Address address;

    @OneToMany (mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<HospitalDepartment> hdList = new ArrayList<>();

    //=====연관 관계 메서드=====//

    public void addDepartment(Department department) {
        HospitalDepartment hd= new HospitalDepartment();
        hd.setHospital(this);
        hd.setDepartment(department);
        this.hdList.add(hd);
        department.getHdList().add(hd);
    }
}
