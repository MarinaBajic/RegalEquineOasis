package com.reo.user_service.dto;

import com.reo.user_service.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRegister {
    private String username;
    private String password;
    private Role role;
}
