package dev.belueu.springbootdependencyinjection.service;

public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world! - Constructor";
    }
}
