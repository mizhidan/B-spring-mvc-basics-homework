package com.thoughtworks.capacity.gtb.mvc.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorException> validExceptionHandler(MethodArgumentNotValidException e) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            stringBuilder.append(error.getDefaultMessage()).append(" ");
        }
        return new ResponseEntity<>(ErrorException.builder().message(stringBuilder.toString()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorException> businessExceptionHandler(UserException e) {
        return new ResponseEntity<>(ErrorException.builder().message(e.getMessage()).build(), e.getHttpStatus());
    }

}
