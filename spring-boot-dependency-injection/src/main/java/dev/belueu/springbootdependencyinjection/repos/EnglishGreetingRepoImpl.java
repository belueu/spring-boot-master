package dev.belueu.springbootdependencyinjection.repos;

public class EnglishGreetingRepoImpl implements EnglishGreetingRepo {
    @Override
    public String getGreeting() {
        return "Hello world! - English (EN) Profile Bean";
    }
}
