package com.reo.horse_service.mapper;

import com.reo.horse_service.dto.BreedDto;
import com.reo.horse_service.model.Breed;
import org.springframework.stereotype.Component;

@Component
public class BreedMapper {

    public BreedDto mapToDto(Breed breed) {
        return BreedDto.builder()
                .name(breed.getName())
                .coatColor(breed.getCoatColor())
                .build();
    }
}
