package com.example.booking_az.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CustomerRequestDto {
    private String name;
    private String surname;
    private String nationality;
    @Email(message = "Please, properly fulfill the email address!")
    private String email;
    @NotEmpty(message = "Gender can not be empty!")
    private String gender;
    private Long id;
    private Long hotelId;
}
