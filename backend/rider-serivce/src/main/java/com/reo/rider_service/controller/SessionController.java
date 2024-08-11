package com.reo.rider_service.controller;

import com.reo.rider_service.dto.SessionRequest;
import com.reo.rider_service.dto.SessionResponse;
import com.reo.rider_service.service.SessionService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sessions")
public class SessionController {

    private SessionService sessionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SessionResponse> getAll() {
        return sessionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionResponse> getById(@PathVariable Long id) {
        try {
            SessionResponse sessionResponse = sessionService.getById(id);
            return ResponseEntity.ok(sessionResponse);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid SessionRequest sessionRequest) {
        sessionService.add(sessionRequest);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByIdHorse(@RequestParam("id-horse") Long id) {
        sessionService.deleteByIdHorse(id);
    }
}
