package dev.belueu.springbootdependencyinjection.config;

import dev.belueu.springbootdependencyinjection.repos.EnglishGreetingRepo;
import dev.belueu.springbootdependencyinjection.repos.EnglishGreetingRepoImpl;
import dev.belueu.springbootdependencyinjection.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    EnglishGreetingRepo englishGreetingRepo() {
        return new EnglishGreetingRepoImpl();
    }

    @Profile({"default", "EN"})
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepo englishGreetingRepo) {
        return new I18nEnglishGreetingService(englishGreetingRepo);
    }

    @Profile("ES")
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }
}
