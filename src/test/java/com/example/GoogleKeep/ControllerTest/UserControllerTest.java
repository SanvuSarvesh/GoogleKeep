package com.example.GoogleKeep.ControllerTest;
//import static org.junit.jupiter.
import com.example.GoogleKeep.Models.User;
import com.example.GoogleKeep.Repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @LocalServerPort
    private int port;
    private String emailId = "sarvesh123@gmail.com";
    @Autowired
    private WebTestClient.Builder webTestClient;
    @MockBean
    private UserRepository userRepository;
    private User user = new User();

    @BeforeEach
    public void mockfun(){
        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.findByEmailId(user.getEmailId())).thenReturn(user.getEmailId());
        //when(userRepository.)
    }

    @Test
    public void addUserTest(){
        ResponseEntity<User> response = webTestClient.baseUrl("http://localhost:/"+port)
                .build()
                .get()
                .uri("/user/add_user")
                //.bodyValue(user)
                //.retrive().toEntry(User.class).block();

    }
}
