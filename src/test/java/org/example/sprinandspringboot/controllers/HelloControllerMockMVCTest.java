package org.example.sprinandspringboot.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(controllers = HelloController.class)
public class HelloControllerMockMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void autowiredWorking(){
        assertNotNull(mockMvc);
    }
    @Test
    void testWithoutName() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("Hello World"))
                .andExpect(model().attribute("user","world"));
    }
}
