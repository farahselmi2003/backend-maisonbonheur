package com.maisonbonheur.perfumebackend.service;

import com.maisonbonheur.perfumebackend.entity.User;
import com.maisonbonheur.perfumebackend.dto.request.RegisterRequest;
import com.maisonbonheur.perfumebackend.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    User createUser(RegisterRequest request);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
    UserResponse getUserProfile(Long id);
    Boolean existsByEmail(String email);
}