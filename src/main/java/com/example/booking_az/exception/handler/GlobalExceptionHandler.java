package com.example.booking_az.exception.handler;

import com.example.booking_az.auth.AuthenticationResponse;
import com.example.booking_az.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ExceptionHandler(UserNameExistException.class)
    public ResponseEntity<?> userNameExistException(UserNameExistException userNameExistException) {
        List<String> details = new ArrayList<>();
        details.add(userNameExistException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(userNameExistException.getMessage(), details);
        log.info("User name exist exception thrown..");
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}