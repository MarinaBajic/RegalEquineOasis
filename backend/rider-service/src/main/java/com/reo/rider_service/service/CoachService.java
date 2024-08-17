package com.reo.rider_service.service;

import com.reo.rider_service.dto.CoachResponse;
import com.reo.rider_service.dto.RiderResponse;
import com.reo.rider_service.exception.EntityDoesNotExistException;
import com.reo.rider_service.mapper.CoachMapper;
import com.reo.rider_service.model.Coach;
import com.reo.rider_service.model.Rider;
import com.reo.rider_service.repository.CoachRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoachService {

    private CoachRepository coachRepository;
    private CoachMapper coachMapper;

    public List<CoachResponse> getAll() {
        List<Coach> coaches = coachRepository.findAll();
        return coachMapper.mapToResponseList(coaches);
    }

    public Coach getEntityById(Long id) {
        return coachRepository.findById(id)
                .orElseThrow(() -> new EntityDoesNotExistException("Coach with id: " + id + " not found.", id));
    }
}
