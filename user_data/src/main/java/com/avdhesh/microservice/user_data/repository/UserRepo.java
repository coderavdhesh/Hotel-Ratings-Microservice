package com.avdhesh.microservice.user_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avdhesh.microservice.user_data.entities.User;

public interface UserRepo extends JpaRepository<User,String> {

}
