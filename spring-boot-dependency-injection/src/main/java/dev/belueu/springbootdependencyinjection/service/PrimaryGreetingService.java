package dev.belueu.springbootdependencyinjection.service;


public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello world! - Primary Bean";
    }
}
