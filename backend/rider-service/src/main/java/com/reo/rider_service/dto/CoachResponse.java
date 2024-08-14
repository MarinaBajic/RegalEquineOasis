package com.reo.rider_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoachResponse {
    private Long id;
    private String name;
    private String surname;
    private Integer yearsOfExperience;
}
