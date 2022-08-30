package com.yjproject.overnight.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Schedule {

    @Id @GeneratedValue
    @Column(name = "schedule_id")
    private Long id;

    private LocalDate date;

    private String reserveTime;

    private Integer amount;

    private EnableReservation enableReservation;


}
