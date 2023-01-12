package com.avdhesh.microservice.hotel_data.exception;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(){
        super("Resource Not found in our database.");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }

}
