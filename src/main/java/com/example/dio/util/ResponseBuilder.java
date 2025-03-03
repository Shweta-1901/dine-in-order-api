package com.example.dio.util;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class ResponseBuilder {


    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus httpStatus, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(httpStatus.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(structure);

    }


    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .build();
        return ResponseEntity.status(status)
                .body(error);
    }


    public static ResponseEntity<FieldErrorResponse> error(HttpStatus status, String message, List<FieldErrorResponse.CustomFieldError> fieldError){
        FieldErrorResponse errorResponse= FieldErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .fieldErrors(fieldError)
                .build();

        return ResponseEntity.status(status)
                .body(errorResponse);
    }

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



