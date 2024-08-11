package com.reo.rider_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class RiderRequest {
    @NotNull(message = "Name must be provided.")
    private String name;

    @NotNull(message = "Surname must be provided.")
    private String surname;

    private String address;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEnrollment;

    @NotNull(message = "Id of coach must be provided.")
    private Long idCoach;
}
