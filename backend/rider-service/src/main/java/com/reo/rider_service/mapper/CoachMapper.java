package com.reo.rider_service.mapper;

import com.reo.rider_service.dto.CoachResponse;
import com.reo.rider_service.model.Coach;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoachMapper {

    public CoachResponse mapToResponse(Coach coach) {
        return CoachResponse.builder()
                .id(coach.getId())
                .name(coach.getName())
                .surname(coach.getSurname())
                .yearsOfExperience(coach.getYearsOfExperience())
                .build();
    }

    public List<CoachResponse> mapToResponseList(List<Coach> coaches) {
        return coaches.stream().map(this::mapToResponse).toList();
    }
}
