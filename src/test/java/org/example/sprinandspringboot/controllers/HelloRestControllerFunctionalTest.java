package org.example.sprinandspringboot.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerFunctionalTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void autowiringWorked(@LocalServerPort int port) {
        assertNotNull(restTemplate);
        System.out.println("server port: " + port);
    }

    @Test
    void greetWithoutName(@LocalServerPort int port) {
        var greeting = restTemplate.getForObject("/rest", GreetingsController.class);
        assertEquals("Hello Worlds", greeting.message());
        System.out.println("mesajul este " + greeting.message());
    }

    @Test
    void greetWithName() {
        ResponseEntity<GreetingsController> response = restTemplate.getForEntity("/rest",
                GreetingsController.class, "Dolly");
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        System.out.println("*********************************************************!");
        System.out.println("statutul acestui REQUEST este " + response.getStatusCode());
        System.out.println("contentul TIp acestui REQUEST este " + response.getHeaders().getContentType());
    }

    @Test
    void unTestCareTesteazaTot() {
        ResponseEntity<GreetingsController> response = restTemplate.getForEntity("/rest",
                GreetingsController.class, "Dolly");
        assertAll(
                () -> assertTrue(response.getStatusCode().is2xxSuccessful()),
                () -> assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType()),
                () -> assertTrue(response.getStatusCode().is2xxSuccessful())
        );
        System.out.println("*********************************************************!");
        System.out.println("statutul acestui REQUEST este " + response.getStatusCode());
        System.out.println("contentul TIp acestui REQUEST este " + response.getHeaders().getContentType());
    }
}

