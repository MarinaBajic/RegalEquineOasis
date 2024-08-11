package com.reo.rider_service.repository;

import com.reo.rider_service.model.Favorite;
import com.reo.rider_service.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findByIdHorseAndRider(Long idHorse, Rider rider);
}