package com.example.GoogleKeep.Controllers;
import org.slf4j.Logger;
import com.example.GoogleKeep.Models.User;
import com.example.GoogleKeep.Services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/add_user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        try {
            logger.info("Post API has stated.");
            logger.warn("Kindly enter correct details.");
            return userService.addUser(user);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return new ResponseEntity<>("There will be something.", HttpStatus.CREATED);
    }

    @GetMapping("/get_user")
    public ResponseEntity<String> getUserDetails(@RequestParam ("emailId")
                                                     String emailId){
        logger.info("Get API has been started.");
        logger.warn("Kindly enter correct username.");
        return userService.getUserDetails(emailId);
    }

    @PutMapping("/update_user")
    public ResponseEntity<String> updateUserDetails(
            @RequestParam("username") String username, @RequestParam String mobileNo){

        logger.info("Update API has been created.");
        logger.warn("Kindly enter valid username");
        return userService.updateUserDetails(username,mobileNo);
    }

    @DeleteMapping("/delete_user")
    public ResponseEntity<String> deleteUserDetails(@RequestParam ("emailId")
                                                        String emailId){
        logger.info("Delete API has been started.");
        logger.warn("Kindly enter correct emailId.");
        return userService.deleteUserDetails(emailId);
    }
}
