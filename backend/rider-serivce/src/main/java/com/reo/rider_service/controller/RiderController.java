package com.reo.rider_service.controller;

import com.reo.rider_service.dto.RiderRequest;
import com.reo.rider_service.dto.RiderResponse;
import com.reo.rider_service.service.RiderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/riders")
@Validated
public class RiderController {

    private RiderService riderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RiderResponse> getAll() {
        return riderService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiderResponse> getById(@PathVariable Long id) {
        try {
            RiderResponse riderResponse = riderService.getById(id);
            return ResponseEntity.ok(riderResponse);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid RiderRequest riderRequest) {
        riderService.add(riderRequest);
    }
}
