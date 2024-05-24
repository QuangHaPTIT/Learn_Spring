package com.example.Learn_Spring.controller;

import com.example.Learn_Spring.dto.request.AuthenticationRequest;
import com.example.Learn_Spring.dto.request.IntrospectRequest;
import com.example.Learn_Spring.dto.response.AuthenticationResponse;
import com.example.Learn_Spring.dto.response.BaseResponse;
import com.example.Learn_Spring.dto.response.IntrospectResponse;
import com.example.Learn_Spring.exception.AppException;
import com.example.Learn_Spring.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.text.ParseException;
import java.util.Date;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @PostMapping("/login")
    public ResponseEntity<BaseResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws AppException {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);
        return ResponseEntity.ok(
                BaseResponse.builder()
                        .result(authenticationResponse)
                        .build()
        );
    }

    @PostMapping("/introspect")
    public ResponseEntity<BaseResponse> introspect(@RequestBody IntrospectRequest introspectRequest) throws ParseException, JOSEException {
        IntrospectResponse introspectResponse = authenticationService.introspect(introspectRequest);
        return ResponseEntity.ok(
                BaseResponse.builder()
                        .result(introspectResponse)
                        .build()
        );
    }

}
