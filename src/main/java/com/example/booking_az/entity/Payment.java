package com.example.booking_az.entity;

import com.example.booking_az.enumaration.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatusEnum paymentStatusEnum;
    private Date paymentDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="booking_id",referencedColumnName = "id")
    private Booking booking;
}
