package com.reo.horse_service.repository;

import com.reo.horse_service.model.Breed;
import com.reo.horse_service.model.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HorseRepository extends JpaRepository<Horse, Long> {

    Optional<Horse> findByFullName(String fullName);

    List<Horse> findAllByBreed(Breed breed);
}