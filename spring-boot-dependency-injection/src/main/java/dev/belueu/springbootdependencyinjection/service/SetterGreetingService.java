package dev.belueu.springbootdependencyinjection.service;

public class SetterGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello world! - Setter";
    }
}
