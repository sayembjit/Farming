package com.mottakin.main.controller;

import com.mottakin.main.exception.CropNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({CropNotFoundException.class})
    public ResponseEntity<?> handleIdNotFoundException()
    {
        return new ResponseEntity<>(new CropNotFoundException().getMessage(), HttpStatus.BAD_REQUEST);
    }
}
