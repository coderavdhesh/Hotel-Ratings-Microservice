package com.avdhesh.microservice.rating_data.repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avdhesh.microservice.rating_data.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating,String>{

    // custom methods 
    public List<Rating> findByUserId(String userID);
    public List<Rating> findByHotelId(String hotelID);
}
