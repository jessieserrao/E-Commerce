package com.santojes.ecommerce.customer.handler;

import com.santojes.ecommerce.customer.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice // enable the exception handler in the application
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handle( CustomerNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException ex){ //TODO: better error handling
        var erros = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors()
                .forEach(error -> {
                 var fieldName = ((FieldError) error).getField();
                 var errorMsg = error.getDefaultMessage();
                 erros.put(fieldName,errorMsg);
                });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(erros));
    }
}
