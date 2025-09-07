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
// 특정 병원에 소속되어 있는 부서 리스트
public class HospitalDepartment {

    @Id @GeneratedValue
    @Column(name = "hospital_depatrtment_id")
    // 중복 불가, NULL 불가
    private Long id;

    @Column(nullable=false, unique=true)
    // 중복 불가, NULL 불가
    private String number;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", nullable=false, unique=true)
    // 중복 불가, NULL 불가
    private Department department;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id", nullable=false)
    // 무조건 중복, NULL 불가
    private Hospital hospital;

    @OneToMany (mappedBy = "hospitalDepartment", cascade = CascadeType.ALL)
    private List<HospitalDoctor> hospitalDoctors = new ArrayList<>();


    //=====연관 관계 메서드=====//

    public void addDoctor(HospitalDoctor hospitalDoctor) {
        // 해당 부서 소속 의사를 추가한다.
        hospitalDoctors.add(hospitalDoctor);

        // 의사의 소속을 해당 부서로 설정한다.
        hospitalDoctor.setHospitalDepartment(this);
    }
}
