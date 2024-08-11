package com.reo.rider_service.repository;

import com.reo.rider_service.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    void deleteByIdHorse(Long id);

    Optional<Session> findByIdHorseAndDateAndTime(Long id, LocalDate date, String time);

}