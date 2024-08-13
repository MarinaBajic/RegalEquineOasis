package com.reo.horse_service.mapper;

import com.reo.horse_service.dto.BreedResponse;
import com.reo.horse_service.model.Breed;
import org.springframework.stereotype.Component;

@Component
public class BreedMapper {

    public BreedResponse mapToResponse(Breed breed) {
        return BreedResponse.builder()
                .id(breed.getId())
                .name(breed.getName())
                .coatColor(breed.getCoatColor())
                .build();
    }
}
