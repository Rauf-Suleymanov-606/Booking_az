package com.example.booking_az.entity;

import com.example.booking_az.enumaration.PaymentMethodEnum;
import com.example.booking_az.enumaration.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatusEnum paymentStatus;
    private Date paymentDate;
    @Enumerated(value = EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
