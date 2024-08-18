package com.reo.rider_service.repository;

import com.reo.rider_service.model.SessionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionTypeRepository extends JpaRepository<SessionType, Long> {
}