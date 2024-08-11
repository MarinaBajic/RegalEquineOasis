package com.reo.rider_service.mapper;

import com.reo.rider_service.dto.RiderResponse;
import com.reo.rider_service.model.Rider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RiderMapper {

    public RiderResponse mapToResponse(Rider rider) {
        return RiderResponse.builder()
                .id(rider.getId())
                .address(rider.getAddress())
                .dateOfBirth(rider.getDateOfBirth())
                .dateOfEnrollment(rider.getDateOfEnrollment())
                .name(rider.getName())
                .surname(rider.getSurname())
                .coachName(rider.getCoach().getName() + " " + rider.getCoach().getSurname())
                .build();
    }

    public List<RiderResponse> mapToResponseList(List<Rider> riders) {
        return riders.stream().map(this::mapToResponse).toList();
    }
}
