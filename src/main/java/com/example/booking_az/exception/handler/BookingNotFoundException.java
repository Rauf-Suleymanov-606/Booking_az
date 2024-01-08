package com.example.booking_az.exception.handler;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String msg){
        super(msg);
    }
}
