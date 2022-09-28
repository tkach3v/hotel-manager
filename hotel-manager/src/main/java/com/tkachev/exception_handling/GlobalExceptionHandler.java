package com.tkachev.exception_handling;

import com.tkachev.exception_handling.exception.FieldNotSpecifiedException;
import com.tkachev.exception_handling.exception.NoSuchEntityException;
import com.tkachev.exception_handling.response.ExceptionResponse;
import com.tkachev.exception_handling.exception.JwtAuthenficationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoSuchEntityException.class, UsernameNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleNoSuchEntityException(Exception exception) {
        ExceptionResponse data = new ExceptionResponse();
        data.setExceptionMessage(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JwtAuthenficationException.class)
    public ResponseEntity<ExceptionResponse> handleJwtAuthenticationException(JwtAuthenficationException exception) {
        ExceptionResponse data = new ExceptionResponse();
        data.setExceptionMessage(exception.getMessage());

        return new ResponseEntity<>(data, exception.getHttpStatus());
    }

    @ExceptionHandler({FieldNotSpecifiedException.class})
    public ResponseEntity<ExceptionResponse> handleInvalidDataExceptions(Exception exception) {
        ExceptionResponse data = new ExceptionResponse();
        data.setExceptionMessage(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.UNPROCESSABLE_ENTITY);
    }


    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        ExceptionResponse data = new ExceptionResponse();
        data.setExceptionMessage(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
