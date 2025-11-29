package com.maisonbonheur.perfumebackend.service;

import com.maisonbonheur.perfumebackend.dto.request.LoginRequest;
import com.maisonbonheur.perfumebackend.dto.request.RegisterRequest;
import com.maisonbonheur.perfumebackend.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    void validateToken(String token);
}