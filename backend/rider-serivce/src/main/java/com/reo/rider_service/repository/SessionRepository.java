package com.reo.rider_service.repository;

import com.reo.rider_service.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}