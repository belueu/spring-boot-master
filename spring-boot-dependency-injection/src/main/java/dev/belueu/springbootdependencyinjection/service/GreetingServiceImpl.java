package dev.belueu.springbootdependencyinjection.service;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world!";
    }
}
