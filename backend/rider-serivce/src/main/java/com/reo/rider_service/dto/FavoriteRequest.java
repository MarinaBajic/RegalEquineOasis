package com.reo.rider_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteRequest {
    @NotNull(message = "Id of rider must be provided.")
    private Long idRider;

    @NotNull(message = "Id of horse must be provided.")
    private Long idHorse;
}
