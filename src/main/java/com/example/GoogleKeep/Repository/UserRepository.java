package com.example.GoogleKeep.Repository;

import com.example.GoogleKeep.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    User findByEmailId(String emailId);
    //Optional<User> findByEmailId(String emailId);
    //void delete(Optional<User> user);
}
