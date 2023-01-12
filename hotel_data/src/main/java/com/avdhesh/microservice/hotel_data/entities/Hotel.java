package com.avdhesh.microservice.hotel_data.entities;

import org.springframework.data.annotation.Transient;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "hotel_data")
public class Hotel {
    
    @Id
    @Column(name = "hotel_id")
    public String id;
    @Column(name = "hotel_name")
    public String name;
    @Column(name = "hotel_location")
    public String location;
    @Column(name = "hotel_discription")
    public String about;

    @Transient
    public double hotelRating;
}
