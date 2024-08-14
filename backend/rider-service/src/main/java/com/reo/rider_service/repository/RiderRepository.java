package com.reo.rider_service.repository;

import com.reo.rider_service.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {
}