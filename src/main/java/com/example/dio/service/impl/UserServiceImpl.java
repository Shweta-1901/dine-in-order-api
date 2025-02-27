package com.example.dio.service.impl;


import com.example.dio.exceptions.UserNotFoundByIdException;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;

import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User registerUser(User user){

        User user2= this.getUser(user);
    this.mapToNewUser(user, user2);
        return userRepository.save(user2);
    }

    private User getUser(User user) {
        User user2;

        switch (user.getUserRole()){
            case Admin -> user2=new Admin();
            case Staff-> user2 = new Staff();
            default -> throw new RuntimeException("Failed to register");

        }
        return user2;
    }

    private  void mapToNewUser(User user, User user2){
        user2.setUserId(user.getUserId());
        user2.setUserName(user.getUserName());
        user2.setUserRole(user.getUserRole());
        user2.setEmail(user.getEmail());
        user2.setPhoneNo(user.getPhoneNo());
        user2.setPassword(user.getPassword());

    }

    @Override
    public User findUserById(long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundByIdException("Failed to find user, user not found bu id"));

//        User user2=this.getUser(userId);
//        this.mapToNewUser(userId,user2);
//        return userRepository.findById(userId);

    }

}
