package com.lionelsamvura.backend.controller.advice;

import com.lionelsamvura.backend.service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<?> exception( Exception ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {RuntimeException.class })
    public ResponseEntity<?> exception( RuntimeException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<?> handleConflict( RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<?> resourceNotFound( ResourceNotFoundException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

