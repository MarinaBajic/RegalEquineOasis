package com.reo.horse_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HorseResponse {
    private Long id;
    private LocalDate dateOfBirth;
    private String fullName;
    private String gender;
    private String nickname;
    private BreedDto breed;
}
