package com.reo.user_service.controller;

import com.reo.user_service.dto.UserRegister;
import com.reo.user_service.model.User;
import com.reo.user_service.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegister userRegister) {
        User user = userService.register(userRegister);
        return ResponseEntity.ok().body(user);
    }
}
