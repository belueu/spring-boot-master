package dev.belueu.springbootdependencyinjection.service;

public class I18nSpanishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hola mundo! - Spanish (ES) Profile Bean";
    }
}
