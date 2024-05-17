package com.example.booking_az.entity;

import com.example.booking_az.enumaration.OrderStatusEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    @Enumerated(value = EnumType.STRING)
    private OrderStatusEnum orderStatusEnum;
    private Double totalPrice;
    private Long orderNo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
     private Payment payment;


    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Room room;
}
