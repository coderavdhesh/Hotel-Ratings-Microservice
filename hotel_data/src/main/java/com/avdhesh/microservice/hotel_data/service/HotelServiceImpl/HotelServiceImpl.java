package com.avdhesh.microservice.hotel_data.service.HotelServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avdhesh.microservice.hotel_data.entities.Hotel;
import com.avdhesh.microservice.hotel_data.entities.Rating;
import com.avdhesh.microservice.hotel_data.exception.ResourceNotFoundException;
import com.avdhesh.microservice.hotel_data.repository.HotelRepo;
import com.avdhesh.microservice.hotel_data.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    public HotelRepo hotelRepo;

    @Autowired
    public RestTemplate restTemplate;

    @Override
    public List<Hotel> listOfHotels() {
        List<Hotel> list = hotelRepo.findAll();

        for (Hotel hotel : list) {
                                                            // hard coded URLs
            Rating[] ratingList = restTemplate.getForObject("http://localhost:8093/ratings/hotels/"+hotel.getId(), Rating[].class);
            
            int count = 0;
            double sum = 0.0;
            for(Rating ratingsData : ratingList) {
                sum += ratingsData.getRating();
                count++;
            }

            double overallRating = sum/count;
            hotel.setHotelRating(overallRating);
        }
        return list;
    }

    @Override
    public Hotel getHotel(String hotelID) {

        Hotel hotel = hotelRepo.findById(hotelID).orElseThrow(() -> new ResourceNotFoundException());
        
                                                        // hard coded URLs
        Rating[] ratingList = restTemplate.getForObject("http://localhost:8093/ratings/hotels/"+hotel.getId(), Rating[].class);
            
        int count = 0;
        double sum = 0.0;
        for(Rating ratingsData : ratingList) {
            sum += ratingsData.getRating();
            count++;
        }

        double overallRating = sum/count;
        hotel.setHotelRating(overallRating);

        return hotel;
    }

    @Override
    public Hotel createNewHotel(Hotel hotel) {
        String randomHotelID = UUID.randomUUID().toString();
        hotel.setId(randomHotelID);
        hotelRepo.save(hotel);
        return hotel; 
    }

    @Override
    public void deleteHotel(String hotelID) {
        Hotel hotel = hotelRepo.findById(hotelID).orElseThrow(() -> new ResourceNotFoundException("The hotel with this ID is not available in our database."));
        hotelRepo.delete(hotel);
    }

    @Override
    public Hotel updateHotelInfo(String hotelID, Hotel hotel) {
        hotelRepo.findById(hotelID).orElseThrow(() -> new ResourceNotFoundException("The hotel with this ID is not available in our database."));
        hotel.setId(hotelID);
        hotelRepo.save(hotel);
        return null;
    }

    @Override
    public Double overallRatingOfHotel(String hotelId) {


        return null;
    }
    
}