package com.reo.horse_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "rider-service", url = "http://localhost:8081")
public interface SessionClient {

    @DeleteMapping("/api/sessions/delete")
    @ResponseStatus(HttpStatus.OK)
    void deleteByIdHorse(@RequestParam("id-horse") Long id);
}
