package com.reo.rider_service.service;

import com.reo.rider_service.dto.*;
import com.reo.rider_service.exception.EntityDoesNotExistException;
import com.reo.rider_service.exception.UnableToAddNewEntityException;
import com.reo.rider_service.feign.HorseClient;
import com.reo.rider_service.mapper.SessionMapper;
import com.reo.rider_service.model.Rider;
import com.reo.rider_service.model.Session;
import com.reo.rider_service.repository.RiderRepository;
import com.reo.rider_service.repository.SessionRepository;
import feign.FeignException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class SessionService {

    private SessionRepository sessionRepository;
    private RiderRepository riderRepository;
    private HorseClient horseClient;
    private SessionMapper sessionMapper;

    public List<SessionResponse> getAll() {
        List<Session> sessions = sessionRepository.findAll();
        return sessionMapper.mapToResponseList(sessions);
    }

    public SessionResponse getById(Long id) {
        Session session = sessionRepository.findById(id).orElseThrow(() -> new EntityDoesNotExistException("Session with id: " + id + " not found.", id));
        return sessionMapper.mapToResponse(session);
    }

    public void add(SessionRequest sessionRequest) {
        Rider rider = riderRepository.findById(sessionRequest.getIdRider()).orElseThrow(() -> new EntityDoesNotExistException("Rider with id: " + sessionRequest.getIdRider() + " does not exist.", sessionRequest.getIdRider()));

        HorseResponse horse;
        try {
            horse = horseClient.getById(sessionRequest.getIdHorse()).getBody();
        } catch (FeignException e) {
            throw new EntityDoesNotExistException("Horse with id: " + sessionRequest.getIdHorse() + " does not exist.", sessionRequest.getIdHorse());
        }

        Optional<Session> horseTaken = sessionRepository.findByIdHorseAndDateAndTime(horse != null ? horse.getId() : null, sessionRequest.getDate(), sessionRequest.getTime());
        if (horseTaken.isPresent())
            throw new UnableToAddNewEntityException("Horse with id: " + (horse != null ? horse.getId() : null) + " is not available for selected date and time. Please choose another.");

        Session session = new Session();
        session.setDate(sessionRequest.getDate());
        session.setTime(sessionRequest.getTime());
        session.setDescription(sessionRequest.getDescription());
        session.setRider(rider);
        session.setIdHorse(horse != null ? horse.getId() : null);

        sessionRepository.save(session);
        log.info("Session with id: {} is saved", session.getId());
    }

    @Transactional
    public void deleteByIdHorse(Long id) {
        sessionRepository.deleteByIdHorse(id);
    }
}
