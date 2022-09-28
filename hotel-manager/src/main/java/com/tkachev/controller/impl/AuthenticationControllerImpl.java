package com.tkachev.controller.impl;

import com.tkachev.controller.AuthenticationController;
import com.tkachev.dto.AuthenticationRequestDto;
import com.tkachev.dto.AuthenticationResponseDto;
import com.tkachev.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthenticationControllerImpl implements AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public AuthenticationResponseDto authenticate(@RequestBody AuthenticationRequestDto authData) {
        return authenticationService.authenticate(authData);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, null);
    }
}
