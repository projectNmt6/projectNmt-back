package com.projectnmt.projectnmt.controller.advice;

import com.projectnmt.projectnmt.exception.SaveException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(SaveException.class)
    public ResponseEntity<?> saveException(SaveException e){
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}
