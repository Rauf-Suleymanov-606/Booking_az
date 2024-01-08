package com.example.booking_az.exception.handler;

import com.example.booking_az.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> customerNotFound(CustomerNotFoundException customerNotFoundException) {
        List<String> details = new ArrayList<>();
        details.add(customerNotFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Customer not found", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<?> bookingNotFoundException(BookingNotFoundException bookingNotFoundException) {
        List<String> details = new ArrayList<>();
        details.add(bookingNotFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Booking not found", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<?> hotelNotFoundException(HotelNotFoundException hotelNotFoundException) {
        List<String> details = new ArrayList<>();
        details.add(hotelNotFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Hotel not found", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<?> roomNotFoundException(RoomNotFoundException roomNotFoundException) {
        List<String> details = new ArrayList<>();
        details.add(roomNotFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Room not found", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<?> paymentNotFoundExeption(PaymentNotFoundException paymentNotFoundException) {
        List<String> details = new ArrayList<>();
        details.add(paymentNotFoundException.getMessage());
        ErrorResponse errorRespons = new ErrorResponse("Payment not found", details);
        return new ResponseEntity<>(errorRespons, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<?> reviewNotFoundException(ReviewNotFoundException reviewNotFoundException) {
        List<String> details = new ArrayList<>();
        details.add(reviewNotFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Review not found", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
