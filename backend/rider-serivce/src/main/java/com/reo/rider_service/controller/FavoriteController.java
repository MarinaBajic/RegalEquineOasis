package com.reo.rider_service.controller;

import com.reo.rider_service.dto.FavoriteRequest;
import com.reo.rider_service.dto.HorseResponse;
import com.reo.rider_service.service.FavoriteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/favorites")
public class FavoriteController {

    private FavoriteService favoriteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFavorite(@RequestBody @Valid FavoriteRequest favoriteRequest) {
        favoriteService.add(favoriteRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HorseResponse> getAllFavoriteHorsesForRider(@RequestParam("id-rider") Long idRider) {
        return favoriteService.getAllFavoriteHorsesForRider(idRider);
    }

    @DeleteMapping("/{idRider}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFavorite(@PathVariable Long idRider, @RequestParam("id-horse") Long idHorse) {
        favoriteService.delete(idRider, idHorse);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteFavoriteByHorseId(@RequestParam("id-horse") Long idHorse) {
        favoriteService.deleteByHorseId(idHorse);
    }
}
