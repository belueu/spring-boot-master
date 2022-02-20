package dev.belueu.springbootdependencyinjection.service;

public class PropertyGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello world! - Property";
    }
}
