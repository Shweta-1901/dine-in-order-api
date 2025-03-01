package com.example.dio.service;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    public UserResponse registerUser(RegistrationRequest user);
 public UserResponse findUserById(long userId);
 public UserResponse updateUserNameById(UserRequest userRequest,long userId );



    // Optional<User> updateUserNameById(Long id, String updatedName);
}
