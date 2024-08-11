package com.reo.rider_service.controller;

import com.reo.rider_service.dto.SessionResponse;
import com.reo.rider_service.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
