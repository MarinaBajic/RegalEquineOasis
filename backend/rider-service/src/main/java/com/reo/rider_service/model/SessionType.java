package com.reo.rider_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class SessionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Double price;
    private Long duration;
    private String description;

    @OneToMany(mappedBy = "sessionType")
    private List<Session> sessions;
}
