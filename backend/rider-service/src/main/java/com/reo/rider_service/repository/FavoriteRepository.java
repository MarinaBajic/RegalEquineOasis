package com.reo.rider_service.repository;

import com.reo.rider_service.model.Favorite;
import com.reo.rider_service.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findByHorseIdAndRider(Long idHorse, Rider rider);

    List<Favorite> findAllByRider(Rider rider);

    void deleteByHorseId(Long idHorse);
}