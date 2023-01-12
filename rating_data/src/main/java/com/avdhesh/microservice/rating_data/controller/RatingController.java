package com.avdhesh.microservice.rating_data.controller;

import org.springframework.web.bind.annotation.RestController;

import com.avdhesh.microservice.rating_data.entities.Rating;
import com.avdhesh.microservice.rating_data.service.RatingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RatingController {

    @Autowired
    public RatingService ratingService;

    // home page
    @GetMapping(value="/")
    public String homePage() {
        return "This is Rating Service.";
    }
    
    // get all ratings
    @GetMapping(value="/ratings")
    public ResponseEntity<List<Rating>> ratings() {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }
    
    // get all ratings my userID
    @GetMapping(value="/ratings/users/{userID}")
    public ResponseEntity<List<Rating>> ratingsByUser(@PathVariable String userID) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByUserID(userID));
    }
    
    // get all ratings my hotelID
    @GetMapping(value="/ratings/hotels/{hotelID}")
    public ResponseEntity<List<Rating>> postMethodName(@PathVariable String hotelID) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByHotelID(hotelID));
    }

    // inputing rating  - creating
    @PostMapping(value="/ratings/add")
    public ResponseEntity<Rating> postMethodName(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));

    }

    @DeleteMapping("/rating/delete/{ratingId}")
    public String getRatingService(@PathVariable String ratingId) {
        try{
            ratingService.deleteRating(ratingId);
            return "deleted";
        }
        catch(Exception ex){
            return "Rating doesn't exists.";
        }
    }
    
}
