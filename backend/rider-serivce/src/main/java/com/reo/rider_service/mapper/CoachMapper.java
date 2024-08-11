package com.reo.rider_service.mapper;

import com.reo.rider_service.dto.CoachDto;
import com.reo.rider_service.model.Coach;
import org.springframework.stereotype.Component;

@Component
public class CoachMapper {

    public CoachDto mapToDto(Coach coach) {
        return CoachDto.builder()
                .name(coach.getName())
                .surname(coach.getSurname())
                .yearsOfExperience(coach.getYearsOfExperience())
                .build();
    }
}
