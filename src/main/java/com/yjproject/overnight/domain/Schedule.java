package com.yjproject.overnight.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Schedule {

    @Id @GeneratedValue
    @Column(name = "schedule_id")
    private Long id;

    @OneToMany(mappedBy = "schedule")
    private List<Order> orders = new ArrayList<>();

    private LocalDate date;

    //06:00 07:00
    private String reserveTime;

    private Integer amount;

    private EnableReservation enableReservation;


}
