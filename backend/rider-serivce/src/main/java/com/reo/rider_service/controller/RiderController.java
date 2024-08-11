package com.reo.rider_service.controller;

import com.reo.rider_service.dto.RiderResponse;
import com.reo.rider_service.service.RiderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/riders")
public class RiderController {

    private RiderService riderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RiderResponse> getAll() {
        return riderService.getAll();
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addNewRider(@RequestBody RiderRequest riderRequest) {
//        riderService.addNewRider(riderRequest);
//    }
}
