package com.reo.user_service.repository;

import com.reo.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
  boolean existsByUsername(String username);
}