package com.example.Learn_Spring.exception;

import org.springframework.web.HttpRequestMethodNotSupportedException;

public class MethodNotAllowedException extends HttpRequestMethodNotSupportedException {
    public MethodNotAllowedException(String message) {
        super(message);
    }
}
