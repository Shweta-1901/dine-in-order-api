package com.example.dio.dto.response;

import com.example.dio.enums.UserRole;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter


public class UserResponse {
    private long userId;
    private String userName;
    private UserRole userRole;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
}
