package com.reo.rider_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessionRequest {
    @NotNull(message = "Date must be provided.")
    private LocalDate date;

    @NotBlank(message = "Time must be provided.")
    private String time;

    @NotNull(message = "Id of rider must be provided.")
    private Long riderId;

    @NotNull(message = "Id of horse must be provided.")
    private Long horseId;

    private String description;
}
