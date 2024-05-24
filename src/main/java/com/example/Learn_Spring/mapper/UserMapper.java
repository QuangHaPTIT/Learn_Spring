package com.example.Learn_Spring.mapper;

import com.example.Learn_Spring.dto.request.UserCreationRequest;
import com.example.Learn_Spring.dto.request.UserUpdateRequest;
import com.example.Learn_Spring.dto.response.UserResponse;
import com.example.Learn_Spring.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
