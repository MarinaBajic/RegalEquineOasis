package com.reo.rider_service.mapper;

import com.reo.rider_service.dto.SessionTypeResponse;
import com.reo.rider_service.model.SessionType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SessionTypeMapper {

    public SessionTypeResponse mapToResponse(SessionType sessionType) {
        return SessionTypeResponse.builder()
                .id(sessionType.getId())
                .type(sessionType.getType())
                .duration(sessionType.getDuration())
                .price(sessionType.getPrice())
                .description(sessionType.getDescription())
                .build();
    }

    public List<SessionTypeResponse> mapToResponseList(List<SessionType> sessionTypes) {
        return sessionTypes.stream().map(this::mapToResponse).toList();
    }
}
