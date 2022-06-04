package com.orelly.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        // model is a map here  model of the data
        model.addAttribute("user", name);
        return "hello"; // why we do it ->  we use in spring something that is called view resolver
        // look for hello.html in src/main/resources/templates -> this is because thymeLeaf  dependecy

    }
}
