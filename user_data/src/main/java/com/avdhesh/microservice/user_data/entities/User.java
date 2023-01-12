package com.avdhesh.microservice.user_data.entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Table(name = "user_data")
public class User {

    @Id
    @Column(name = "userID")
    String userID;
    @Column(name = "userName")
    String userName;
    @Column(name = "userEmail")
    String email;
    @Column(name = "aboutUser")
    String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
    
}
