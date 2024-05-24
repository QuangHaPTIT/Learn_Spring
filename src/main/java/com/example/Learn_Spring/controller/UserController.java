package com.example.Learn_Spring.controller;

import com.example.Learn_Spring.dto.request.UserCreationRequest;
import com.example.Learn_Spring.dto.request.UserUpdateRequest;
import com.example.Learn_Spring.dto.response.BaseResponse;
import com.example.Learn_Spring.dto.response.UserResponse;
import com.example.Learn_Spring.exception.AppException;
import com.example.Learn_Spring.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<BaseResponse> createUser(@RequestBody @Valid UserCreationRequest userCreationRequest) throws AppException {
        UserResponse userResponse = userService.createUser(userCreationRequest);
        return ResponseEntity.ok(
                BaseResponse.builder()
                        .message("Create user success")
                        .result(userResponse)
                        .build()
        );
    }

    @GetMapping("")
    public ResponseEntity<BaseResponse> getAllUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication.getName());
        authentication.getAuthorities().forEach(auth -> {log.info(auth.getAuthority());});
        List<UserResponse> userResponses = userService.getAllUser();
        return ResponseEntity.ok(
                BaseResponse.builder()
                        .message("Get all user success")
                        .result(userResponses)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> updateUser(@PathVariable(value = "id") Long userId,
                                                   @RequestBody @Valid UserUpdateRequest userUpdateRequest) throws AppException {
        UserResponse userResponse = userService.updateUser(userId, userUpdateRequest);
        return ResponseEntity.ok(
                BaseResponse.builder()
                        .message("Update user success")
                        .result(userResponse)
                        .build()
        );
    }

}
