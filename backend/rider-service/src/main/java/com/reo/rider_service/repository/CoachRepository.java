package com.reo.rider_service.repository;

import com.reo.rider_service.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}