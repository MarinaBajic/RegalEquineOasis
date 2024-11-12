package com.reo.user_service.service;

import com.reo.user_service.dto.UserRegister;
import com.reo.user_service.mapper.UserMapper;
import com.reo.user_service.model.User;
import com.reo.user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User register(UserRegister userRegister) {
        if (userRepository.existsByUsername(userRegister.getUsername())) {
            throw new IllegalStateException("Username already exists");
        }
        User user = userMapper.toEntity(userRegister);
        return userRepository.save(user);
    }
}
