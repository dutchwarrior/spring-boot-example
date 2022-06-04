package com.orelly.demo.controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;

public class HelloControllerTest {

    @Test
    public void sayHello() {
        HelloController controller = new HelloController();
        Model model =  new BindingAwareConcurrentModel();
        String result = controller.sayHello("World", model);
        assertAll(
                ()-> assertEquals("hello", result),
                ()-> assertEquals("World", model.getAttribute("user"))
        );
    }
}
