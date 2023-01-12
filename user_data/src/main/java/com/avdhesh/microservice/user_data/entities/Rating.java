package com.avdhesh.microservice.user_data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    public String ratingId;
    public String userId;
    public String hotelId;
    public int rating;
    public String feedback;

    public Hotel hotel;
    
}
