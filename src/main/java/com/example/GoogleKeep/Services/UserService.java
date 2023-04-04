package com.example.GoogleKeep.Services;

import com.example.GoogleKeep.Models.User;
import com.example.GoogleKeep.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public ResponseEntity<String> addUser(User user){
        userRepository.save(user);
        return new ResponseEntity<>("New user has been created.", HttpStatus.CREATED);
    }

    public ResponseEntity<String> getUserDetails(String emailId){
        User user =userRepository.findByEmailId(emailId);
        //Optional<User> user = userRepository.findByEmailId(emailId);
        String userString = user.toString();
        return new ResponseEntity<>("Details of user :- \n"+userString,HttpStatus.FOUND);
    }

    public ResponseEntity<String> updateUserDetails(String emailId, String mobileNo){
        User user = userRepository.findByEmailId(emailId);
        user.setMobileNo(mobileNo);
        userRepository.save(user);
        //Optional<User> user = userRepository.findByEmailId(emailId);
        return new ResponseEntity<>("User details has been updated",HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteUserDetails(String emailId){
        User user = userRepository.findByEmailId(emailId);
        userRepository.delete(user);
        return new ResponseEntity<>("Your credentials has been removed.",HttpStatus.OK);
    }
}
