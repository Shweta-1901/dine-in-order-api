package com.example.dio.util;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SimpleErrorResponse {
    private String type;
    private int status; // 404
    private String message; // failed to update the user, the user is not found by id


}
