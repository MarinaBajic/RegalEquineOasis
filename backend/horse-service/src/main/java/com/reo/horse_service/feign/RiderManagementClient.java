package com.reo.horse_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rider-service")
public interface RiderManagementClient {

    @DeleteMapping("/api/sessions")
    void deleteSessionByHorseId(@RequestParam("id-horse") Long idHorse);

    @DeleteMapping("/api/favorites")
    void deleteFavoriteByHorseId(@RequestParam("id-horse") Long idHorse);
}
