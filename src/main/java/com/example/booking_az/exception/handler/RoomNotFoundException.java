package com.example.booking_az.exception.handler;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(String msg){
        super(msg);
    }
}
