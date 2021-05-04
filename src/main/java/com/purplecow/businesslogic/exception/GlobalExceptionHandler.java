package com.purplecow.businesslogic.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@ControllerAdvice
public class GlobalExceptionHandler
{
    //Specific exceptions

    @ExceptionHandler(value = ResourceAccessException.class)
    public ResponseEntity<?> handleResourceAccessException(ConfigDataResourceNotFoundException exception, WebRequest request)
    {
        ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        ResponseEntity<?> responseToReturn = new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
        return responseToReturn;
    }


    //Global exceptions

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request)
    {
        ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        ResponseEntity<?> responseToReturn = new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseToReturn;
    }


}
