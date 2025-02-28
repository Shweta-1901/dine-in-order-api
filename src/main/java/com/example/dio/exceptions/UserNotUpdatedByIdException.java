package com.example.dio.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserNotUpdatedById extends RuntimeException{
    private String message;
}
