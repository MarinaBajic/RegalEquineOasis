package com.reo.user_service.auth.service;

import com.reo.user_service.auth.dto.AuthRequest;
import com.reo.user_service.auth.dto.JwtResponse;
import com.reo.user_service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final ApplicationContext context;

    private final AuthenticationManager authManager;

    public JwtResponse verify(AuthRequest authRequest) {
        Authentication auth =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        if (auth.isAuthenticated()) {
            String username = authRequest.getUsername();
            String role = null;

            if (!auth.getAuthorities().isEmpty()) {
                role = auth.getAuthorities().iterator().next().getAuthority();
            }
            String token = jwtService.generateToken(username, role);
            return JwtResponse.builder()
                    .token(token)
                    .build();
        }
        else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }

    public boolean validateToken(String token, User user) {
        UserDetails userDetails = context.getBean(UserDetailsServiceImpl.class).loadUserByUsername(user.getUsername());
        return jwtService.validateToken(token, userDetails);
    }
}
