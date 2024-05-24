package com.example.Learn_Spring.service;

import com.example.Learn_Spring.dto.request.UserCreationRequest;
import com.example.Learn_Spring.dto.request.UserUpdateRequest;
import com.example.Learn_Spring.dto.response.UserResponse;
import com.example.Learn_Spring.exception.AppException;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserCreationRequest userCreationRequest) throws AppException;
    List<UserResponse> getAllUser();
    UserResponse updateUser(Long userId, UserUpdateRequest userUpdateRequest) throws AppException;
}
