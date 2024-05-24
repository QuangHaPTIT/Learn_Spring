package com.example.Learn_Spring.dto.response;

import com.example.Learn_Spring.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String username;

    @JsonProperty("first_name")
    String firstName;
    LocalDate dob;

    @JsonProperty("last_name")
    String lastName;

    Set<String> roles;

}
