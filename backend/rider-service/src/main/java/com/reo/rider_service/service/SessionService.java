package com.reo.rider_service.service;

import com.reo.rider_service.dto.*;
import com.reo.rider_service.exception.EntityDoesNotExistException;
import com.reo.rider_service.exception.UnableToAddNewEntityException;
import com.reo.rider_service.mapper.SessionMapper;
import com.reo.rider_service.mapper.SessionTypeMapper;
import com.reo.rider_service.model.Rider;
import com.reo.rider_service.model.Session;
import com.reo.rider_service.model.SessionType;
import com.reo.rider_service.repository.SessionRepository;
import com.reo.rider_service.repository.SessionTypeRepository;
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
    private SessionTypeRepository sessionTypeRepository;

    private RiderService riderService;
    private HorseService horseService;

    private SessionMapper sessionMapper;
    private SessionTypeMapper sessionTypeMapper;

    public List<SessionResponse> getAll() {
        List<Session> sessions = sessionRepository.findAll();
        return sessionMapper.mapToResponseList(sessions);
    }

    public SessionResponse getById(Long id) {
        Session session = sessionRepository.findById(id).orElseThrow(() -> new EntityDoesNotExistException("Session with id: " + id + " not found.", id));
        return sessionMapper.mapToResponse(session);
    }

    public void add(SessionRequest sessionRequest) {
        Rider rider = riderService.getEntityById(sessionRequest.getRiderId());
        HorseResponse horse = horseService.getById(sessionRequest.getHorseId());

        Optional<Session> horseTaken = sessionRepository.findByHorseIdAndDateAndTime(horse != null ? horse.getId() : null, sessionRequest.getDate(), sessionRequest.getTime());
        if (horseTaken.isPresent())
            throw new UnableToAddNewEntityException("Horse with id: " + (horse != null ? horse.getId() : null) + " is not available for selected date and time. Please choose another.");

        Session session = new Session();
        session.setDate(sessionRequest.getDate());
        session.setTime(sessionRequest.getTime());
        session.setDescription(sessionRequest.getDescription());
        session.setRider(rider);
        session.setHorseId(horse != null ? horse.getId() : null);

        sessionRepository.save(session);
        log.info("Session with id: {} is saved", session.getId());
    }

    @Transactional
    public void deleteByHorseId(Long idHorse) {
        sessionRepository.deleteByHorseId(idHorse);
    }

    public List<SessionTypeResponse> getAllTypes() {
        List<SessionType> sessionTypes = sessionTypeRepository.findAll();
        return sessionTypeMapper.mapToResponseList(sessionTypes);
    }
}
