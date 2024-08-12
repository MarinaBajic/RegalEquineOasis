package com.reo.rider_service.feign;

import com.reo.rider_service.dto.HorseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="horse-service", url = "http://localhost:8080")
public interface HorseManagementClient {

    @GetMapping("/api/horses/{idHorse}")
    ResponseEntity<HorseResponse> getHorseById(@PathVariable Long idHorse);
}
