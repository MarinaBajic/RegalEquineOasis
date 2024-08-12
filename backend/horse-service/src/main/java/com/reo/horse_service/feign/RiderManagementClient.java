package com.reo.horse_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rider-service", url = "http://localhost:8081")
public interface RiderManagementClient {

    @DeleteMapping("/api/sessions/delete")
    void deleteSessionByIdHorse(@RequestParam("id-horse") Long idHorse);

    @DeleteMapping("/api/favorites/delete")
    void deleteFavoriteByIdHorse(@RequestParam("id-horse") Long idHorse);
}
