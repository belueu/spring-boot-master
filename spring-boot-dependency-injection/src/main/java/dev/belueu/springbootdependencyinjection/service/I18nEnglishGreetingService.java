package dev.belueu.springbootdependencyinjection.service;

import dev.belueu.springbootdependencyinjection.repos.EnglishGreetingRepo;

public class I18nEnglishGreetingService implements GreetingService {

    private final EnglishGreetingRepo englishGreetingRepo;

    public I18nEnglishGreetingService(EnglishGreetingRepo englishGreetingRepo) {
        this.englishGreetingRepo = englishGreetingRepo;
    }

    @Override
    public String sayGreeting() {
        return englishGreetingRepo.getGreeting();
    }
}
