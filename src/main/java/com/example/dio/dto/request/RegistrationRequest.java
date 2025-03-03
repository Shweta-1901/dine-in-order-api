package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegistrationRequest {

//    @NotNull(message = "Username cannot be null or blank")
  @NotBlank(message = "Username cannot be blank")
    @NotEmpty(message = "Username cannot be empty")
  @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = ("Username can only contain Alphabets, Numbers and Underscore"))
    private String userName;

@NotBlank(message = "Username cannot be blank")
    @NotEmpty(message ="Username cannot be null or blank" )
@Email(regexp ="^[a-z0-9._]+@gmail\\.com$" , message = "Email must be valid gmail address")
    private String email;

@Pattern(regexp ="^[A-Z](?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{7,}$", message = ("Password must start with an uppercase letter, be at least 8 characters long, and include a lowercase letter, a digit, and a special character"))
    private String password;

@Pattern(regexp ="^[0-9]{9,10}$", message = ("Invalid PhoneNo"))
    private String phoneNo;
    private UserRole userRole;


}
