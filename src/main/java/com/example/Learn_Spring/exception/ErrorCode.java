package com.example.Learn_Spring.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001, "User existed"),
    USERNAME_INVALID(1002, "Username must be at least 3 characters"),
    PASSWORD_INVALID(1003, "Password must be at least 8 characters"),
    UNCATEGORIZED_INVALID(999, "Uncategorized error"),
    USER_NOT_FOUND(1004, "User not found"),
    METHOD_NOT_ALLOWED(1005, "Method not allowed"),
    UNAUTHENTICATED(1006, "Un authenticated")
    ;
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;


}
