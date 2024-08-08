package com.reo.horse_service.mappers;

import com.reo.horse_service.dto.HorseResponse;
import com.reo.horse_service.model.Horse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HorseMapper {

    public HorseResponse mapToResponse(Horse horse) {
        return HorseResponse.builder()
                .idHorse(horse.getId())
                .dateOfBirth(horse.getDateOfBirth())
                .fullName(horse.getFullName())
                .gender(horse.getGender())
                .nickname(horse.getNickname())
                .breedName(horse.getBreed().getName())
                .build();
    }

    public List<HorseResponse> mapToResponseList(List<Horse> horses) {
        return horses.stream().map(this::mapToResponse).toList();
    }
}
