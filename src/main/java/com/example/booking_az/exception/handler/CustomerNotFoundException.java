package com.example.booking_az.exception.handler;

public class CustomerNotFoundException extends  RuntimeException{
    public CustomerNotFoundException(String msg){
        super(msg);
    }
}
