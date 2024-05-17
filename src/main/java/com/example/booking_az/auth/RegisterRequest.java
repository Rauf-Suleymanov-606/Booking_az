package com.example.booking_az.auth;

import com.example.booking_az.enumaration.RoleEnum;
import com.example.booking_az.exception.authValidator.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String userName;
    @ValidPassword(
            message = "Password must contain minimum 8 characters, uppercase," +
                    " lowercase, special character and digit! ")
    private String password;
    private RoleEnum role;
}
