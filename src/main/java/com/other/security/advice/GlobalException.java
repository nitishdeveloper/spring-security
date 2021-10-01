package com.other.security.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.other.security.exceptions.ResourceFoundException;
import com.other.security.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalException {

    @Autowired
    private ObjectMapper objectMapper;

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleResourceNotFoundException(ResourceNotFoundException exception){
        ErrorObject object = ErrorObject.builder()
                .timestamp(LocalDateTime.now())
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage()).build();
    return new ResponseEntity<>(object,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleResourceFoundException(ResourceFoundException exception){
        ErrorObject object = ErrorObject.builder()
                .timestamp(LocalDateTime.now())
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST)
                .message(exception.getMessage()).build();
        return new ResponseEntity<>(object,HttpStatus.BAD_REQUEST);
    }
}
