package com.avdhesh.microservice.hotel_data.service;

import java.util.List;

import com.avdhesh.microservice.hotel_data.entities.Hotel;

public interface HotelService {

    // retrieve data
    List<Hotel> listOfHotels();
    Hotel getHotel(String hotelID);

    // create
    Hotel createNewHotel(Hotel hotel);

    // delete
    void deleteHotel(String hotelID);

    // updation
    Hotel updateHotelInfo(String hotelID, Hotel hotel);

    // getting overall rating of hotels
    Double overallRatingOfHotel(String hotelId);
    
}
