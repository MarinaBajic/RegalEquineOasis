package com.reo.horse_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "rider-service", url = "http://localhost:8081")
public interface RiderManagementClient {

    @DeleteMapping("/api/sessions/delete")
    @ResponseStatus(HttpStatus.OK)
    void deleteSessionByIdHorse(@RequestParam("id-horse") Long id);

    @DeleteMapping("/api/favorites/delete")
    @ResponseStatus(HttpStatus.OK)
    void deleteFavoriteByIdHorse(@RequestParam("id-horse") Long id);
}
