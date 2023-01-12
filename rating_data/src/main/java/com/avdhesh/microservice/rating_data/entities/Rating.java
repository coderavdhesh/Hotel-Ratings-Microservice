package com.avdhesh.microservice.rating_data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "rating_data")
public class Rating {

    @Id
    public String ratingId;
    @Column(name = "userID")
    public String userId;
    @Column(name = "hotelId")
    public String hotelId;
    @Column(name = "rating")
    public int rating;
    @Column(name = "feedback")
    public String feedback;

}