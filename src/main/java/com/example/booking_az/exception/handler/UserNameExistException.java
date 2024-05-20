package com.example.booking_az.exception.handler;

public class UserNameExistException extends RuntimeException{
    public UserNameExistException(String msg){
        super(msg);
    }
}
