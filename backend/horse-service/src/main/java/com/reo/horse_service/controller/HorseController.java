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
    public List<HorseResponse> getAll() {
        return horseService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorseResponse> getById(@PathVariable Long id) {
        try {
            HorseResponse horseResponse = horseService.getById(id);
            return ResponseEntity.ok(horseResponse);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid HorseRequest horseRequest) {
        horseService.add(horseRequest);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam("id-horse") Long id) {
        horseService.delete(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<HorseResponse> getAllByBreed(@RequestParam("id-breed") Long id) {
        return horseService.getAllByBreed(id);
    }
}
