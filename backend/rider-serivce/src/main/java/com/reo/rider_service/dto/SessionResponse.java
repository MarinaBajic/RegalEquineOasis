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
public class SessionResponse {
    private Long id;
    private LocalDate date;
    private String description;
    private String time;
    private String riderName;
    private String horseFullName;
}
