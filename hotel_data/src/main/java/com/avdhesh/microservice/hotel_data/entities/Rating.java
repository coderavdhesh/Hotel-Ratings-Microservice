package com.avdhesh.microservice.hotel_data.entities;

import jakarta.persistence.Id;
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

    @Id
    public String ratingId;
    public String userId;
    public String hotelId;
    public int rating;
    public String feedback;

}