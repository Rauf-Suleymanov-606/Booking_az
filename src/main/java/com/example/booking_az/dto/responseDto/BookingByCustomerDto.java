package com.example.booking_az.dto.responseDto;

import com.example.booking_az.enumaration.OrderStatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookingByCustomerDto {
   private long id;
   private String name;
   private List<BookingDto> booking;
   @Data
   public static class BookingDto{
       private long id;
       private Date checkInDate;
       private Date checkOutDate;
       @Enumerated(value = EnumType.STRING)
       private OrderStatusEnum orderStatusEnum;
       private Double totalPrice;
       private Long orderNo;
   }
}
