package com.tkachev.exception_handling.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class JwtAuthenficationException extends AuthenticationException {

    private HttpStatus httpStatus;

    public JwtAuthenficationException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}
