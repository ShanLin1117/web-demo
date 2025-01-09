package com.shan.webdemo.controller;

import com.shan.webdemo.dto.AuthRequest;
import com.shan.webdemo.dto.AuthResponse;
import com.shan.webdemo.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        
        if (passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            String accessToken = jwtService.generateToken(userDetails.getUsername());
            String refreshToken = jwtService.generateRefreshToken(userDetails.getUsername());
            
            return ResponseEntity.ok(AuthResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .build());
        }
        
        throw new BadCredentialsException("Invalid username or password");
    }
}