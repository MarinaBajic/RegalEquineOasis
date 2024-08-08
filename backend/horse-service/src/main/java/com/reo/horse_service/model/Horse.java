package com.reo.horse_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String nickname;
    private String gender;
    private LocalDate dateOfBirth;

    @ManyToOne
    private Breed breed;
}

