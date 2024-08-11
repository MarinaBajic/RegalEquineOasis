package com.reo.rider_service.service;

import com.reo.rider_service.dto.SessionResponse;
import com.reo.rider_service.mapper.SessionMapper;
import com.reo.rider_service.model.Session;
import com.reo.rider_service.repository.SessionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class SessionService {

    private SessionRepository sessionRepository;


    private SessionMapper sessionMapper;

    public List<SessionResponse> getAll() {
        List<Session> sessions = sessionRepository.findAll();
        return sessionMapper.mapToResponseList(sessions);
    }
}
