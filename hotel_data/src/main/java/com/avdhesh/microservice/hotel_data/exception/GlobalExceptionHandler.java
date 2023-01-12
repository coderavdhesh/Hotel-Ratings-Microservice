package com.avdhesh.microservice.hotel_data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.avdhesh.microservice.hotel_data.exceptionResponsePayLoad.JSONresponce;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<JSONresponce> notFoundExcceptionHandler(ResourceNotFoundException ex){
        String exceptionMeassahe = ex.getMessage();
        JSONresponce responce =  JSONresponce.builder().meassage(exceptionMeassahe).httpStatus(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity<JSONresponce>(responce, HttpStatus.NOT_FOUND);
    }
}
