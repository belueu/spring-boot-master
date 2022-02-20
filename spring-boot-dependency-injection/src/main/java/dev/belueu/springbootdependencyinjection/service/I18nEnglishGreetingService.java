package dev.belueu.springbootdependencyinjection.service;

public class I18nEnglishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello world! - English (EN) Profile Bean";
    }
}
