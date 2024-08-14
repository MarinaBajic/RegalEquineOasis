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
    public List<RiderResponse> getAllRiders() {
        return riderService.getAll();
    }

    @GetMapping("/{idRider}")
    public ResponseEntity<RiderResponse> getRiderById(@PathVariable Long idRider) {
        try {
            RiderResponse riderResponse = riderService.getById(idRider);
            return ResponseEntity.ok(riderResponse);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRider(@RequestBody @Valid RiderRequest riderRequest) {
        riderService.add(riderRequest);
    }
}
