package com.avdhesh.microservice.rating_data.service;

import java.util.List;

import com.avdhesh.microservice.rating_data.entities.Rating;

public interface RatingService {
    
    // create
    Rating create(Rating rating);

    // get all 
    List<Rating> getAllRatings();

    // get all by userID
    List<Rating> getRatingsByUserID(String userID);

    // get all by hotelID
    List<Rating> getRatingsByHotelID(String hotelID);

    // deleting ratings by its id
    void deleteRating(String ratingId);

}
