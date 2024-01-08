package com.example.booking_az.exception.handler;

public class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException(String msg){
        super(msg);
    }
}
