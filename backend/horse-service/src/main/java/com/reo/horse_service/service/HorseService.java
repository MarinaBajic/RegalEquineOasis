package com.reo.horse_service.service;

import com.reo.horse_service.dto.HorseRequest;
import com.reo.horse_service.dto.HorseResponse;
import com.reo.horse_service.exception.EntityAlreadyExistsException;
import com.reo.horse_service.exception.EntityDoesNotExistException;
import com.reo.horse_service.mapper.HorseMapper;
import com.reo.horse_service.model.Breed;
import com.reo.horse_service.model.Horse;
import com.reo.horse_service.repository.HorseRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class HorseService {

    private HorseRepository horseRepository;
    private RiderService riderService;
    private BreedService breedService;
    private HorseMapper horseMapper;

    public List<HorseResponse> getAll() {
        List<Horse> horses = horseRepository.findAll();
        return horseMapper.mapToResponseList(horses);
    }

    public HorseResponse getById(Long id) {
        return horseMapper.mapToResponse(getEntityById(id));
    }

    public Horse getEntityById(Long id) {
        return horseRepository.findById(id)
                .orElseThrow(() -> new EntityDoesNotExistException("Horse with id: " + id + " not found.", id));
    }

    public void add(HorseRequest horseRequest) {
        Optional<Horse> horseOptional = horseRepository.findByFullName(horseRequest.getFullName());
        if (horseOptional.isPresent()) {
            throw new EntityAlreadyExistsException("Horse with full name: '" + horseRequest.getFullName() + "' already exists in the DB.", horseOptional.get().getId());
        }

        Breed breed = breedService.getEntityById(horseRequest.getBreedId());

        Horse horse = new Horse();
        horse.setDateOfBirth(horseRequest.getDateOfBirth());
        horse.setFullName(horseRequest.getFullName());
        horse.setGender(horseRequest.getGender());
        horse.setNickname(horseRequest.getNickname());
        horse.setBreed(breed);

        horseRepository.save(horse);
        log.info("Horse with id: {} is saved.", horse.getId());
    }

    @Transactional
    public void delete(Long id) {
        Horse horse = getEntityById(id);
        riderService.deleteCascadeHorseInfo(horse.getId());
        horseRepository.deleteById(horse.getId());
        log.info("Horse with id: {} successfully deleted.", horse.getId());
    }

    public List<HorseResponse> getAllByBreed(Long id) {
        Breed breed = breedService.getEntityById(id);
        List<Horse> horses = horseRepository.findAllByBreed(breed);
        return horseMapper.mapToResponseList(horses);
    }
}
