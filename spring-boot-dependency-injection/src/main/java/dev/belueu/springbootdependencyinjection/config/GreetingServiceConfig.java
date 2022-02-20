package dev.belueu.springbootdependencyinjection.config;

import dev.belueu.springbootdependencyinjection.service.ConstructorGreetingService;
import dev.belueu.springbootdependencyinjection.service.PropertyGreetingService;
import dev.belueu.springbootdependencyinjection.service.SetterGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
