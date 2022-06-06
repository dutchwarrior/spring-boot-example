package com.orelly.demo.json;

import org.springframework.stereotype.Component;


public class Greeting2 {

    private String message;

    public Greeting2() {
    }

    public Greeting2(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                '}';
    }
}
