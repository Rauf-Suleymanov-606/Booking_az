package com.example.booking_az.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CustomerRequestDto {
    private String name;
    private String surname;
    private String nationality;
    @Email(message = "Invalid email format")
    private String email;
    @NotEmpty
    private String gender;
    private Long id;
    private Long hotelId;
}
