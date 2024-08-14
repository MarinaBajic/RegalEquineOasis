package com.reo.rider_service.service;

import com.reo.rider_service.dto.HorseResponse;
import com.reo.rider_service.exception.EntityDoesNotExistException;
import com.reo.rider_service.feign.HorseManagementClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HorseService {

    private HorseManagementClient horseClient;

    public HorseResponse getById(Long idHorse) {
        try {
            return horseClient.getHorseById(idHorse).getBody();
        } catch (FeignException e) {
            throw new EntityDoesNotExistException("Horse with id: " + idHorse + " does not exist.", idHorse);
        }
    }
}
