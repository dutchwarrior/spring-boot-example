package com.orelly.demo.config;

import com.orelly.demo.json.Greeting2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {

    @Bean
    public Greeting2 defaultGreeting2() {
        return new Greeting2("Hello, World!");
    }

    @Bean
    public Greeting2 whatUpGreeting2() {
        return new Greeting2("What up?");
    }
}
