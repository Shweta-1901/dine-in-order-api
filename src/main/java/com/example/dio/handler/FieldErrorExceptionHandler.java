package com.example.dio.handler;

import ch.qos.logback.classic.Level;
import com.example.dio.util.FieldErrorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;



@RestControllerAdvice
@AllArgsConstructor
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {




    protected ResponseEntity<Object> handlerMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //  List<FieldErrorResponse.CustomFieldError> errors = new ArrayList<>();
//        List<ObjectError> objectErrors = ex.getAllErrors();
//
//        for (ObjectError objectError : objectErrors) {
//            CustomFieldError fieldError = (CustomFieldError) objectError;
//
//            FieldErrorResponse.CustomFieldError error = createFieldError(objectError, fieldError);
//
//            errors.add(error);
//        }


        List<FieldErrorResponse.CustomFieldError> errors = ex.getAllErrors().stream()
                .map(error -> (FieldError) error)
                .map(this::createFieldError)
                .toList();


        FieldErrorResponse error = createFieldErrorResponse(status, errors);
        return ResponseEntity.status(status)
                .body(error);
    }


        private FieldErrorResponse createFieldErrorResponse (HttpStatusCode status, List < FieldErrorResponse.CustomFieldError > errors){
        FieldErrorResponse error = FieldErrorResponse.builder()
                .type(status.toString())
            .status(status.value())
            .message("Invalid Input")
           .fieldErrors(errors)
           . build();
        return error;


    }
    private FieldErrorResponse.CustomFieldError createFieldError(FieldError fieldError) {
        FieldErrorResponse.CustomFieldError error = FieldErrorResponse.createFieldError(
            fieldError.getDefaultMessage(),
            fieldError.getRejectedValue(),
            fieldError.getField());
return error;

}
}