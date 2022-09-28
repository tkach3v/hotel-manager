package com.tkachev.security.impl;

import com.tkachev.dao.UserDao;
import com.tkachev.dto.AuthenticationRequestDto;
import com.tkachev.dto.AuthenticationResponseDto;
import com.tkachev.entity.User;
import com.tkachev.exception_handling.exception.JwtAuthenficationException;
import com.tkachev.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProviderImpl jwtTokenProvider;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto authData) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authData.getEmail(), authData.getPassword()));
            User user = userDao.getAll().stream()
                    .filter(u -> u.getEmail().equals(authData.getEmail()))
                    .findFirst()
                    .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));

            String token = jwtTokenProvider.createToken(authData.getEmail(), user.getRole().name());

            return new AuthenticationResponseDto(
                    authData.getEmail(),
                    token
            );
        } catch (AuthenticationException e) {
            throw new JwtAuthenficationException("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }
    }
}
