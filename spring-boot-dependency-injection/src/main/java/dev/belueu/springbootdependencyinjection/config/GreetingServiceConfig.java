package dev.belueu.springbootdependencyinjection.config;

import dev.belueu.springbootdependencyinjection.repos.EnglishGreetingRepo;
import dev.belueu.springbootdependencyinjection.repos.EnglishGreetingRepoImpl;
import dev.belueu.springbootdependencyinjection.service.*;
import dev.belueu.springbootdependencyinjection.service.pets.PetService;
import dev.belueu.springbootdependencyinjection.service.pets.PetServiceFactory;
import org.springframework.context.annotation.*;

@ImportResource("classpath:spring-config.xml")
@Configuration
public class GreetingServiceConfig {

    //    @Bean
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

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile("dog")
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile({"cat", "default"})
    @Primary
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Profile("snake")
    @Bean
    PetService snakePetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("snake");
    }

}
