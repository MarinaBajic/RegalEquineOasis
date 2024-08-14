package com.reo.rider_service.service;

import com.reo.rider_service.exception.EntityDoesNotExistException;
import com.reo.rider_service.model.Coach;
import com.reo.rider_service.repository.CoachRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoachService {

    private CoachRepository coachRepository;

    public Coach getEntityById(Long id) {
        return coachRepository.findById(id)
                .orElseThrow(() -> new EntityDoesNotExistException("Coach with id: " + id + " not found.", id));
    }
}
