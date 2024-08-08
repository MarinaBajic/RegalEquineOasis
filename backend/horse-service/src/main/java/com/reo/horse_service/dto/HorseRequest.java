package com.reo.horse_service.dto;

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
public class HorseRequest {
    @NotNull(message = "Date of birth must be provided.")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Full name must be provided.")
    private String fullName;

    @NotBlank(message = "Gender must be provided.")
    private String gender;

    private String nickname;

    @NotNull(message = "Id of breed must be provided.")
    private Long idBreed;
}
