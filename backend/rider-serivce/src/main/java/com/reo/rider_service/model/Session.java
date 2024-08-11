package com.reo.rider_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Rider rider;

    @Column(name = "horse_id")
    private Long idHorse;

    private LocalDate date;
    private String time;
    private String description;
}

