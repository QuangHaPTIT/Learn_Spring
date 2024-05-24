package com.example.Learn_Spring.service.impl;

import com.example.Learn_Spring.dto.request.UserCreationRequest;

import com.example.Learn_Spring.dto.request.UserUpdateRequest;
import com.example.Learn_Spring.dto.response.UserResponse;
import com.example.Learn_Spring.entity.User;
import com.example.Learn_Spring.enums.Role;
import com.example.Learn_Spring.exception.AppException;
import com.example.Learn_Spring.exception.ErrorCode;
import com.example.Learn_Spring.mapper.UserMapper;
import com.example.Learn_Spring.repository.UserRepository;
import com.example.Learn_Spring.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public UserResponse createUser(UserCreationRequest userCreationRequest) throws AppException {
        if(userRepository.existsByUsername(userCreationRequest.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(userCreationRequest);
        user.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));
        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userCreationResponses = users.stream().map(user -> userMapper.toUserResponse(user))
                .collect(Collectors.toList());
        return userCreationResponses;
    }

    @Override
    @Transactional
    public UserResponse updateUser(Long userId, UserUpdateRequest userUpdateRequest) throws AppException {
        User user = userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        userMapper.updateUser(user, userUpdateRequest);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }


}
