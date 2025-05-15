package com.autointerview.service;

import com.autointerview.dto.auth.AuthRequest;
import com.autointerview.dto.auth.AuthResponse;
import com.autointerview.dto.auth.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);
    AuthResponse refreshToken(String refreshToken);
    void logout(String accessToken);
} 