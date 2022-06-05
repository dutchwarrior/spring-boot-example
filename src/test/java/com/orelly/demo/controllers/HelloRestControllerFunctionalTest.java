package com.orelly.demo.controllers;

import com.orelly.demo.json.Greeting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


/*
  web environment is based on a random port -> start up an actual server for me
  deploy the application to that server, run this test and stop the test
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerFunctionalTest {


    private @Autowired TestRestTemplate template;

    @Test
    public void greetWithMe() {

        Greeting response = template.getForObject("/rest?name=Dolly", Greeting.class);
        Assertions.assertEquals("Hello, Dolly!", response.getMessage());
    }

    @Test
    public void greetWithoutName() {
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);

        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
        Assertions.assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());

        Greeting body = entity.getBody();
        if(body != null) {
            Assertions.assertEquals("Hello, World!", body.getMessage());
        }

    }
}
