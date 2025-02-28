package com.example.dio.service.impl;


import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.enums.UserRole;
import com.example.dio.exceptions.UserNotFoundByIdException;
import com.example.dio.mapper.UserMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;

import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.dio.enums.UserRole.ADMIN;
import static com.example.dio.enums.UserRole.STAFF;


@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest){

        User user= this.createUserByRole(registrationRequest.getUserRole());

        userMapper.mapToUserEntity(registrationRequest,user);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }


    @Override
    public UserResponse findUserById(long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundByIdException("Failed to find user, user not found by id"));
        return userMapper.mapToUserResponse(user);
//        User user2=this.getUser(userId);
//        this.mapToNewUser(userId,user2);
//        return userRepository.findById(userId);

    }

    @Override
    public UserResponse updateUserNameById(UserRequest userRequest,long userId) {
        User exuser = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundByIdException("user not updated"));
        userMapper.mapToNewUser(userRequest,exuser);
        userRepository.save(exuser);
        return userMapper.mapToUserResponse(exuser);
    }

    private User createUserByRole(UserRole user) {
        User user2;

        switch (user){
            case ADMIN -> user2=new Admin();
            case STAFF-> user2 = new Staff();
            default -> throw new RuntimeException("Failed to register");

        }
        return user2;
    }

//    private  void mapToNewUser(User source, User target){
//        target .setUserId(source.getUserId());
//        target.setUserName(source.getUserName());
//        target.setUserRole(source.getUserRole());
//        target.setEmail(source.getEmail());
//        target.setPhoneNo(source.getPhoneNo());
//        target.setPassword(source.getPassword());
//
//    }


}


