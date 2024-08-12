package com.reo.horse_service.controller;

import com.reo.horse_service.dto.HorseRequest;
import com.reo.horse_service.dto.HorseResponse;
import com.reo.horse_service.service.HorseService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/horses")
@Validated
public class HorseController {

    private HorseService horseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HorseResponse> getAllHorses() {
        return horseService.getAll();
    }

    @GetMapping("/{idHorse}")
    public ResponseEntity<HorseResponse> getHorseById(@PathVariable Long idHorse) {
        try {
            HorseResponse horseResponse = horseService.getById(idHorse);
            return ResponseEntity.ok(horseResponse);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addHorse(@RequestBody @Valid HorseRequest horseRequest) {
        horseService.add(horseRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteHorse(@RequestParam("id-horse") Long idHorse) {
        horseService.delete(idHorse);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<HorseResponse> getAllHorsesByBreed(@RequestParam("id-breed") Long idBreed) {
        return horseService.getAllByBreed(idBreed);
    }
}
