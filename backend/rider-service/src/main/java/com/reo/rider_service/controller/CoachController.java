package com.reo.rider_service.controller;

import com.reo.rider_service.dto.CoachResponse;
import com.reo.rider_service.service.CoachService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/coaches")
public class CoachController {

    private CoachService coachService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CoachResponse> getAllCoaches() {
        return coachService.getAll();
    }
}
