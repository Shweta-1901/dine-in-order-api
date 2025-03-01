package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegistrationRequest {
    private String userName;
    private String email;
    private String password;
    private String phoneNo;
    private UserRole userRole;
}
