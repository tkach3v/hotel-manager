package com.tkachev.controller;

import com.tkachev.dto.AuthenticationRequestDto;
import com.tkachev.dto.AuthenticationResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthenticationController {

    AuthenticationResponseDto authenticate(@RequestBody AuthenticationRequestDto request);

    void logout(HttpServletRequest request, HttpServletResponse response);
}
