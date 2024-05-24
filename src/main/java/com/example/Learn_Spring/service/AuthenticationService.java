package com.example.Learn_Spring.service;

import com.example.Learn_Spring.dto.request.AuthenticationRequest;
import com.example.Learn_Spring.dto.request.IntrospectRequest;
import com.example.Learn_Spring.dto.response.AuthenticationResponse;
import com.example.Learn_Spring.dto.response.IntrospectResponse;
import com.example.Learn_Spring.exception.AppException;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws AppException;
    IntrospectResponse introspect(IntrospectRequest introspectRequest) throws JOSEException, ParseException;
}
