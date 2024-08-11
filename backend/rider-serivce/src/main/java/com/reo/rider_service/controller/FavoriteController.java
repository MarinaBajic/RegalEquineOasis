package com.reo.rider_service.controller;

import com.reo.rider_service.dto.FavoriteRequest;
import com.reo.rider_service.service.FavoriteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/favorites")
public class FavoriteController {

    private FavoriteService favoriteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid FavoriteRequest favoriteRequest) {
        favoriteService.add(favoriteRequest);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFavoriteByIdHorse(@RequestParam("id-horse") Long id) {
        favoriteService.deleteByHorseId(id);
    }
}
