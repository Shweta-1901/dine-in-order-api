package com.example.dio.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserNotUpdatedByIdException extends RuntimeException{
   public UserNotUpdatedByIdException (String message){
       super(message);
   }


}
