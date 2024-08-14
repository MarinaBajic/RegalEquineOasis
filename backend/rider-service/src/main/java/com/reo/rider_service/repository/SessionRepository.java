package com.reo.rider_service.repository;

import com.reo.rider_service.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Optional<Session> findByHorseIdAndDateAndTime(Long idHorse, LocalDate date, String time);

    void deleteByHorseId(Long idHorse);
}