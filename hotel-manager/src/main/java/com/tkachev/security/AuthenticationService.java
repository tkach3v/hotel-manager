package com.tkachev.security;

import com.tkachev.dto.AuthenticationRequestDto;
import com.tkachev.dto.AuthenticationResponseDto;

public interface AuthenticationService {

    AuthenticationResponseDto authenticate(AuthenticationRequestDto authData);
}
