package com.avdhesh.microservice.user_data.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource not found in our database.");
    }

    public ResourceNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }

}