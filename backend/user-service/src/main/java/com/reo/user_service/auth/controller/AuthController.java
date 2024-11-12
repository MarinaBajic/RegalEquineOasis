package com.reo.user_service.auth.controller;

import com.reo.user_service.auth.dto.AuthRequest;
import com.reo.user_service.auth.dto.JwtResponse;
import com.reo.user_service.model.User;
import com.reo.user_service.auth.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @GetMapping("/session")
    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody AuthRequest authRequest) {
        return authService.verify(authRequest);
    }

    @GetMapping("/validate")
    public boolean validateToken(@RequestParam("token") String token, @RequestBody User user) {
        return authService.validateToken(token, user);
    }
}
