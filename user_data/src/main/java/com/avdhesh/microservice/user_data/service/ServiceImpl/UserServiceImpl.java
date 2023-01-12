package com.avdhesh.microservice.user_data.service.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avdhesh.microservice.user_data.entities.Hotel;
import com.avdhesh.microservice.user_data.entities.Rating;
import com.avdhesh.microservice.user_data.entities.User;
import com.avdhesh.microservice.user_data.exception.ResourceNotFoundException;
import com.avdhesh.microservice.user_data.repository.UserRepo;
import com.avdhesh.microservice.user_data.service.UserService;

import ch.qos.logback.classic.Logger;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public RestTemplate restTemplate;

    public Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUser(String userID) {
        // User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        User user = userRepo.findById(userID).orElseThrow(() -> new ResourceNotFoundException());

        //http://localhost:8093/ratings/users/8733852b-f7bd-4f09-91a1-5792fda67837

        // geting data into Rating object Array
        Rating[] ratingOfUsers = restTemplate.getForObject("http://localhost:8093/ratings/users/"+userID, Rating[].class);
        logger.info("{}", ratingOfUsers);

        // converting array into List
        List<Rating> ratings = Arrays.stream(ratingOfUsers).toList();

        // iterating list of ratings to get the hotel Data
        List<Rating> ratingList = ratings.stream().map(rating ->{

            ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://localhost:8092/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotelData = hotelEntity.getBody();
            // Hotel hotel = hotelService.getHotel(rating.getHotelId());
            logger.info("{}",hotelData);

            rating.setHotel(hotelData);
            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }

    // getting all users 
    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepo.findAll();

        for (User user : userList) {
            ArrayList<Rating> ratings = restTemplate.getForObject("http://localhost:8093/ratings/users/"+user.getUserID(), ArrayList.class);
            logger.info("{}", ratings);

            if(ratings == null)
                user.setRatings(null);

            user.setRatings(ratings);
        }
        return userList;
    }

    // creating new user
    @Override
    public User createUser(User user) {
        String rendomUserId = UUID.randomUUID().toString();
        user.setUserID(rendomUserId);
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(String userID) {
        userRepo.deleteById(userID);
    }

    @Override
    public User updateUser(String userId, User user) {

        User updated = null;
        user.setUserID(userId);

        try{
            userRepo.deleteById(userId);
            userRepo.save(user);
            updated = user;
        }
        catch(Exception ex){
            throw new ResourceNotFoundException("There is no such user exixts.");
        }
        return updated;
    }
    
}
