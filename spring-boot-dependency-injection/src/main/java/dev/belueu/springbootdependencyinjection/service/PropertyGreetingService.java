package dev.belueu.springbootdependencyinjection.service;

import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello world! - Property";
    }
}
