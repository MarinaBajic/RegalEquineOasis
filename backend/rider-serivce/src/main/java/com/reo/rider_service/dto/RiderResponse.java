package com.reo.rider_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RiderResponse {
    private Long id;
    private String name;
    private String surname;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEnrollment;
    private CoachResponse coach;
}
