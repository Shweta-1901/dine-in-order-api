package com.example.dio.mapper;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

//@Component
@Mapper(componentModel = "Spring")
public interface UserMapper {

    void mapToUserEntity(UserRequest userRequest, @MappingTarget User user);

     UserResponse mapToUserResponse(User user);

     void mapToUserEntity(RegistrationRequest registrationRequest, @MappingTarget User user);

     void mapToNewUser(UserRequest source, @MappingTarget User target);

}