package com.reo.rider_service.service;

import com.reo.rider_service.dto.FavoriteRequest;
import com.reo.rider_service.dto.HorseResponse;
import com.reo.rider_service.exception.EntityDoesNotExistException;
import com.reo.rider_service.exception.UnableToAddNewEntityException;
import com.reo.rider_service.feign.HorseClient;
import com.reo.rider_service.model.Favorite;
import com.reo.rider_service.model.Rider;
import com.reo.rider_service.repository.FavoriteRepository;
import com.reo.rider_service.repository.RiderRepository;
import feign.FeignException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class FavoriteService {

    private FavoriteRepository favoriteRepository;
    private RiderRepository riderRepository;
    private HorseClient horseClient;

    public void add(FavoriteRequest favoriteRequest) {
        HorseResponse horse;
        try {
            horse = horseClient.getById(favoriteRequest.getHorseId()).getBody();
        } catch (FeignException e) {
            throw new EntityDoesNotExistException("Horse with id: " + favoriteRequest.getHorseId() + " does not exist.", favoriteRequest.getHorseId());
        }

        Rider rider = riderRepository.findById(favoriteRequest.getRiderId())
                .orElseThrow(() -> new EntityDoesNotExistException("Rider with id: " + favoriteRequest.getRiderId() + " does not exist in the DB.", favoriteRequest.getRiderId()));

        Optional<Favorite> alreadyIsFavorite = favoriteRepository.findByHorseIdAndRider(horse != null ? horse.getId() : null, rider);
        if (alreadyIsFavorite.isPresent())
            throw new UnableToAddNewEntityException("Horse with id: " + (horse != null ? horse.getId() : null) + " is already favorite for rider with id: " + rider.getId());

        Favorite favorite = new Favorite();
        favorite.setHorseId(horse != null ? horse.getId() : null);
        favorite.setRider(rider);

        favoriteRepository.save(favorite);
        log.info("Favorite horse with id: {} is saved.", favorite.getId());
    }

    @Transactional
    public void deleteByHorseId(Long id) {
        favoriteRepository.deleteByHorseId(id);
    }
}
