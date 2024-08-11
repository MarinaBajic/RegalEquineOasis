package com.reo.rider_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEnrollment;

    @ManyToOne
    private Coach coach;

    @OneToMany(mappedBy = "rider")
    private List<Session> sessions;

//    @OneToMany(mappedBy = "rider")
//    private List<Favorite> favorites;
}
