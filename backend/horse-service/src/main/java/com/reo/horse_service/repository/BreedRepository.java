package com.reo.horse_service.repository;

import com.reo.horse_service.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed, Long> {
}