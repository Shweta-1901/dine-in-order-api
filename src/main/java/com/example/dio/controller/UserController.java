package com.example.dio.controller;


import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import com.example.dio.service.UserService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody RegistrationRequest registrationRequest) {
      UserResponse  user = userService.registerUser(registrationRequest);
    return ResponseBuilder.success(HttpStatus.CREATED, "User Created",user);
    }


// ResponseStructure<User> structure= new ResponseStructure<>();
//        structure.setData(user);
//        structure.setStatus(HttpStatus.CREATED.value());
//        structure.setMessage("user created");
//ResponseStructure<User> responseStructure=ResponseStructure.<User>builder().status(HttpStatus.CREATED.value()).message("User Created").data(user).build();
//return ResponseEntity.status(HttpStatus.CREATED).body(responseStructure);

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable long userId){
         UserResponse user = userService.findUserById(userId);

        return ResponseBuilder.success(HttpStatus.OK, "User Found",user);
    }
@PutMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserById( @PathVariable long userId, @RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.updateUserNameById(userRequest,userId);
        return ResponseBuilder.success(HttpStatus.OK,"user not updated",userResponse);
  //  return userService.updateUserNameById(userId,updatedUser);
    }
}
