package com.reo.rider_service.mapper;

import com.reo.rider_service.dto.HorseResponse;
import com.reo.rider_service.dto.SessionResponse;
import com.reo.rider_service.feign.HorseClient;
import com.reo.rider_service.model.Session;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SessionMapper {

    private HorseClient horseClient;
    private RiderMapper riderMapper;

    public SessionResponse mapToResponse(Session session) {
        HorseResponse horse = horseClient.getById(session.getHorseId()).getBody();

        return SessionResponse.builder()
                .id(session.getId())
                .date(session.getDate())
                .description(session.getDescription())
                .time(session.getTime())
                .rider(riderMapper.mapToResponse(session.getRider()))
                .horseFullName(horse != null ? horse.getFullName() : null)
                .build();
    }

    public List<SessionResponse> mapToResponseList(List<Session> sessions) {
        return sessions.stream().map(this::mapToResponse).toList();
    }
}
