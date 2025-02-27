package com.example.dio.util;

import com.example.dio.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    //esponseStructure<User> structure= new ResponseStructure<>();
    //        structure.setData(user);
//        structure.setStatus(HttpStatus.CREATED.value());
//        structure.setMessage("user created");
//ResponseStructure<User> responseStructure=ResponseStructure.<User>builder().status(HttpStatus.CREATED.value()).message("User Created").data(user).build();
//return ResponseEntity.status(HttpStatus.CREATED).body(responseStructure);
    public static <T>ResponseEntity<ResponseStructure<T>> success(HttpStatus httpStatus,String message,T data)
    {
        ResponseStructure<T> structure=  ResponseStructure.<T>builder()
                .status(httpStatus.value())
                .message(message)
           .data(data)
                .build();
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(structure);

    }
//    public static <T>ResponseEntity<ResponseStructure<T>> success(HttpStatus httpStatus, HttpHeaders header, String message, T data)
//    {
//        ResponseStructure<T> structure=  ResponseStructure.<T>builder()
//                .status(httpStatus.value())
//                .message(message)
//                .data(data)
//                .build();
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .header(header)
//                .body(structure);
//
//    }


}
