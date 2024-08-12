package com.reo.rider_service.service;

import com.reo.rider_service.dto.RiderRequest;
import com.reo.rider_service.dto.RiderResponse;
import com.reo.rider_service.exception.EntityDoesNotExistException;
import com.reo.rider_service.mapper.RiderMapper;
import com.reo.rider_service.model.Coach;
import com.reo.rider_service.model.Rider;
import com.reo.rider_service.repository.RiderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RiderService {

    private RiderRepository riderRepository;
    private CoachService coachService;
    private RiderMapper riderMapper;

    public List<RiderResponse> getAll() {
        List<Rider> riders = riderRepository.findAll();
        return riderMapper.mapToResponseList(riders);
    }

    public RiderResponse getById(Long id) {
        Rider rider = riderRepository.findById(id)
                .orElseThrow(() -> new EntityDoesNotExistException("Rider with id: " + id + " not found.", id));
        return riderMapper.mapToResponse(rider);
    }

    public Rider getEntityById(Long id) {
        return riderRepository.findById(id)
                .orElseThrow(() -> new EntityDoesNotExistException("Rider with id: " + id + " not found.", id));
    }

    public void add(RiderRequest riderRequest) {
        Coach coach = coachService.getEntityById(riderRequest.getCoachId());

        Rider rider = new Rider();
        rider.setAddress(riderRequest.getAddress());
        rider.setDateOfBirth(riderRequest.getDateOfBirth());
        rider.setDateOfEnrollment(riderRequest.getDateOfEnrollment());
        rider.setName(riderRequest.getName());
        rider.setSurname(riderRequest.getSurname());
        rider.setCoach(coach);

        riderRepository.save(rider);
        log.info("Rider with id: {} is saved", rider.getId());
    }
}
