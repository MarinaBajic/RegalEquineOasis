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
    public List<SessionResponse> getAllSessions() {
        return sessionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionResponse> getSessionById(@PathVariable Long idSession) {
        try {
            SessionResponse sessionResponse = sessionService.getById(idSession);
            return ResponseEntity.ok(sessionResponse);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addSession(@RequestBody @Valid SessionRequest sessionRequest) {
        sessionService.add(sessionRequest);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSessionByHorseId(@RequestParam("id-horse") Long idHorse) {
        sessionService.deleteByHorseId(idHorse);
    }
}
