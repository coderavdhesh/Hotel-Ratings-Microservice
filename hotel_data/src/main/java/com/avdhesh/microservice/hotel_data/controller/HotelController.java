package com.avdhesh.microservice.hotel_data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avdhesh.microservice.hotel_data.entities.Hotel;
import com.avdhesh.microservice.hotel_data.service.HotelService;

@RestController
public class HotelController {

    @Autowired
    public HotelService hotelService;

    @GetMapping(value="/")
    public String homePage() {
        return "This is a Hotel service!";
    }

    // getting all hotels
    @GetMapping(value="/hotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        // TODO: retrieve data request
        List<Hotel> list = hotelService.listOfHotels();
        return ResponseEntity.ok(list);
    }
    
    // getting specific hotel data by it's ID
    @GetMapping(value="/hotels/{hotelID}")
    public ResponseEntity<Hotel> getingHotel(@PathVariable String hotelID) {
        // TODO: retrieve data request
        Hotel hotel = hotelService.getHotel(hotelID);
        return ResponseEntity.ok(hotel);
    }

    // creating new hotel data in Database
    @PostMapping(value="/hotels/add")
    public ResponseEntity<Hotel> newHotel(@RequestBody Hotel newHotel) {
        // TODO: process POST request
        hotelService.createNewHotel(newHotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
    }

    @PutMapping(value="/hotels/{hotelID}")
    public ResponseEntity<Hotel> updatingHotel(@PathVariable String hotelID, @RequestBody Hotel updatedHotel) {
        // TODO: process PUT request
        Hotel updatedHoteldata = hotelService.updateHotelInfo(hotelID, updatedHotel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedHoteldata);
    }
    

    @DeleteMapping(value = "/hotels/{hotelID}")
    public ResponseEntity<String> deleteingHotel(@PathVariable String hotelID){
        // TODO: Delete the data
        hotelService.deleteHotel(hotelID);
        return ResponseEntity.status(HttpStatus.OK).body("Hotel :"+hotelID+" deleted!");
    }
    
}
