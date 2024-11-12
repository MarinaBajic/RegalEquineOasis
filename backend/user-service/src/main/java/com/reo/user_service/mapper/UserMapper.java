package com.reo.user_service.mapper;

import com.reo.user_service.dto.UserRegister;
import com.reo.user_service.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public User toEntity(UserRegister userRegister) {
        User user = new User();
        user.setUsername(userRegister.getUsername());
        user.setPassword(passwordEncoder.encode(userRegister.getPassword()));
        user.setRole(userRegister.getRole());
        return user;
    }
}
