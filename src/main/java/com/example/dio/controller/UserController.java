package com.example.dio.controller;


import com.example.dio.service.UserService;
import lombok.AllArgsConstructor;
import model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user){
        user = userService.registerUser(user);

        ResponseStructure<User> structure= new ResponseStructure<>();
        structure.setDate(user);
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("user created");

        return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
    }

}
