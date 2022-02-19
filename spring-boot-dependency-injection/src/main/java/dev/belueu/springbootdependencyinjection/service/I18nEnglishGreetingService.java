package dev.belueu.springbootdependencyinjection.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"default", "EN"})
@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello world! - English (EN) Profile Bean";
    }
}
