package com.example.booking_az.exception.handler;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String msg){
        super(msg);
    }
}
