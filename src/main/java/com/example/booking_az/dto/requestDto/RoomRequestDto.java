package com.example.booking_az.dto.requestDto;

import com.example.booking_az.enumaration.RoomStatusEnum;
import com.example.booking_az.enumaration.RoomTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomRequestDto {
    @Enumerated(EnumType.STRING)
    private RoomTypeEnum roomType;
    @NotNull(message = "Can not be null!")
    private Double pricePerNight;
    @Enumerated(EnumType.STRING)
    private RoomStatusEnum roomStatus;
    private Integer roomNo;
    private Long customerId;
    private Long hotelId;
}
