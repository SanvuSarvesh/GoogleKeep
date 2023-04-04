package com.example.GoogleKeep.ServiceTest;

import com.example.GoogleKeep.Services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
public class UserServiceTest {
    @Mock
    private WebTestClient webTestClient;
    @InjectMocks
    private UserService userService;
    @Test
    public void postApiTesting (){

    }
}
