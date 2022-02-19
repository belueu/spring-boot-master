package dev.belueu.springbootdependencyinjection.controller;

import dev.belueu.springbootdependencyinjection.service.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
