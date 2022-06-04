package com.orelly.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(HelloController.class)
public class HelloControllerMockMVCTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHelloWithoutName() throws Exception {
        mvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user", "World"));
    }

    @Test
    public void testHelloWithName() throws Exception {
        mvc.perform(get("/hello").param("name", "Dolly").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user", "Dolly"));
    }
}
