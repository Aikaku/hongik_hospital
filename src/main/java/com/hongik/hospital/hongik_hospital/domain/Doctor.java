package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
// 의사 협회에 등록되어 있는 의사 리스트
public class Doctor {

    @Id
    @GeneratedValue
    @Column(name = "doctor_id", nullable=false)
    // 중복 불가, NULL 불가
    // 의사 등록 번호
    private Long id;

    @Column(nullable=false)
    // 중복 가능, NULL 불가
    // 의사 이름
    private String name;

    @Column(nullable=false)
    // 중복 가능, NULL 불가
    // 의사 경력, 등록 시점부터 1년마다 +1
    private int personal_history;

    @OneToOne (fetch = LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne (fetch = LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
