package com.avdhesh.microservice.rating_data.service.RatingServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avdhesh.microservice.rating_data.entities.Rating;
import com.avdhesh.microservice.rating_data.repostitory.RatingRepo;
import com.avdhesh.microservice.rating_data.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    public RatingRepo ratingRepo;

    @Override
    public Rating create(Rating rating) {
        String randomID = UUID.randomUUID().toString();
        rating.setRatingId(randomID);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserID(String userID) {
        return ratingRepo.findByUserId(userID);
    }

    @Override
    public List<Rating> getRatingsByHotelID(String hotelID) {
        return ratingRepo.findByHotelId(hotelID);
    }

    @Override
    public void deleteRating(String ratingId) {
        ratingRepo.deleteById(ratingId);
    }
    
}
