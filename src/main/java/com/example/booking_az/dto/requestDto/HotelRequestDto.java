package com.example.booking_az.dto.requestDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class HotelRequestDto {
    @NotEmpty(message = "Hotel name can not be empty!")
    private String name;
    @Pattern(regexp = "^[*]*$",message = "Star rating can contain only asteriks!")
    private String starRating;
    private String city;
    private String street;
    @NotNull(message = "Room count can not be null!")
    private Integer roomCount;
    private Long id;
}
