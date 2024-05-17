package com.example.booking_az.exception.handler;

import com.example.booking_az.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException notFoundException) {
        List<String> details = new ArrayList<>();
        details.add(notFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(notFoundException.getMessage(), details);
        log.info("Not found exception thrown..");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> validationErrors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            validationErrors.add(errorMessage);
        });
        ErrorResponse response = new ErrorResponse(ex.getMessage(), validationErrors);
        log.info("Validation exception thrown..");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}