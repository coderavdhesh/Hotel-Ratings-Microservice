package com.avdhesh.microservice.hotel_data.exceptionResponsePayLoad;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JSONresponse {
    String meassage;
    HttpStatus httpStatus;
    boolean success;
}
