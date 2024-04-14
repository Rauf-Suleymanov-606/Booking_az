package com.example.booking_az.exception.handler;

import com.example.booking_az.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException notFoundException) {
        List<String> details = new ArrayList<>();
        details.add(notFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(notFoundException.getMessage(), details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
//    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
//        List<ErrorResponse> errorResponse = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(error -> new ErrorResponse(error.getField())
//                .collect(Collectors.toList());
//}
