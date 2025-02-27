package com.example.dio.handler;

import com.example.dio.exceptions.UserNotFoundByIdException;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    public ResponseEntity<SimpleErrorResponse> getMessage(UserNotFoundByIdException ex){
        return ResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
