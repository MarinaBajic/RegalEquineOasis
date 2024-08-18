package com.reo.rider_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessionTypeResponse {
    private Long id;
    private String type;
    private Double price;
    private Long duration;
    private String description;
}
