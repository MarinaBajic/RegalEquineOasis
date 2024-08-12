package com.reo.rider_service.service;

import com.reo.rider_service.dto.FavoriteRequest;
import com.reo.rider_service.dto.HorseResponse;
import com.reo.rider_service.exception.UnableToAddNewEntityException;
import com.reo.rider_service.model.Favorite;
import com.reo.rider_service.model.Rider;
import com.reo.rider_service.repository.FavoriteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class FavoriteService {

    private FavoriteRepository favoriteRepository;
    private RiderService riderService;
    private HorseService horseService;

    public void add(FavoriteRequest favoriteRequest) {
        HorseResponse horse = horseService.getById(favoriteRequest.getHorseId());
        Rider rider = riderService.getEntityById(favoriteRequest.getRiderId());

        Optional<Favorite> favoriteExists = favoriteRepository.findByHorseIdAndRider(horse != null ? horse.getId() : null, rider);
        if (favoriteExists.isPresent())
            throw new UnableToAddNewEntityException("Horse with id: " + (horse != null ? horse.getId() : null) + " is already favorite for rider with id: " + rider.getId());

        Favorite favorite = new Favorite();
        favorite.setHorseId(horse != null ? horse.getId() : null);
        favorite.setRider(rider);

        favoriteRepository.save(favorite);
        log.info("Favorite horse with id: {} is saved.", favorite.getId());
    }

    public List<HorseResponse> getAllFavoriteHorsesForRider(Long idRider) {
        Rider rider = riderService.getEntityById(idRider);
        List<Favorite> favorites = favoriteRepository.findAllByRider(rider);
        return favorites.stream().map((favorite -> horseService.getById(favorite.getHorseId()))).toList();
    }

    @Transactional
    public void deleteByHorseId(Long idHorse) {
        favoriteRepository.deleteByHorseId(idHorse);
    }
}
