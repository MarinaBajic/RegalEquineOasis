package com.reo.horse_service.service;

import com.reo.horse_service.exception.EntityDoesNotExistException;
import com.reo.horse_service.model.Breed;
import com.reo.horse_service.repository.BreedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BreedService {

    private BreedRepository breedRepository;

    public Breed getEntityById(Long id) {
        return breedRepository.findById(id)
                .orElseThrow(() -> new EntityDoesNotExistException("Breed with id: " + id + " does not exist.", id));
    }
}
