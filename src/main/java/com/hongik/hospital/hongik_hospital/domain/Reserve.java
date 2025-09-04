package com.hongik.hospital.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reserve {

    @Id @GeneratedValue
    @Column(name = "reserve_id")
    private int id;

    @Enumerated
    private ReserveStatus status;
}
