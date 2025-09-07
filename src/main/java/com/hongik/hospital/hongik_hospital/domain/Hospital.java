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

    @Column(nullable=false, unique=true)
    @Embedded
    // 중복 불가, NULL 불가
    private Address address;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    // NULL 가능
    private List<HospitalDepartment> hospitalDepartments = new ArrayList<>();

    //=====연관 관계 메서드=====//

    public void addDepartment(HospitalDepartment hospitalDepartment) {
        hospitalDepartments.add(hospitalDepartment);
        hospitalDepartment.setHospital(this);
    }

    // 병원이 처음 생겼을 때
    public static Hospital createHospital(String name, Address address,
                                          List<HospitalDepartment> hospitalDepartments) {
        Hospital hospital = new Hospital();

        hospital.setName(name);
        hospital.setAddress(address);

        for(HospitalDepartment hospitalDepartment : hospitalDepartments){
            hospital.addDepartment(hospitalDepartment);
        }

        return hospital;
    }
}
