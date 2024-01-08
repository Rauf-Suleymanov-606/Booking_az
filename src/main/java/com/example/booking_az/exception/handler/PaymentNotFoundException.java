package com.example.booking_az.exception.handler;

public class PaymentNotFoundException extends  RuntimeException{
    public PaymentNotFoundException (String msg){
        super(msg);
    }
}
