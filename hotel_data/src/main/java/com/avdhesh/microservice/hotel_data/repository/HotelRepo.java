package com.avdhesh.microservice.hotel_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avdhesh.microservice.hotel_data.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{
    
}
