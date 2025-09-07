package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
}
