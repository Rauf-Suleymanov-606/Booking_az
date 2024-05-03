package com.example.booking_az.entity;

import com.example.booking_az.enumaration.RoomStatusEnum;
import com.example.booking_az.enumaration.RoomTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoomTypeEnum roomType;
    private Double pricePerNight;
    @Enumerated(EnumType.STRING)
    private RoomStatusEnum roomStatus;
    private Integer roomNo;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="booking_id",referencedColumnName = "id")
    private Booking booking;
}
