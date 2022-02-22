package dev.belueu.springbootdependencyinjection.config;

import dev.belueu.springbootdependencyinjection.datasource.FakeDataSource;
import dev.belueu.springbootdependencyinjection.repos.EnglishGreetingRepo;
import dev.belueu.springbootdependencyinjection.repos.EnglishGreetingRepoImpl;
import dev.belueu.springbootdependencyinjection.service.*;
import dev.belueu.springbootdependencyinjection.service.pets.PetService;
import dev.belueu.springbootdependencyinjection.service.pets.PetServiceFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(ConstructorConfig.class)
@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:spring-config.xml")
@Configuration
public class GreetingServiceConfig {

    // Using constructor binding and injecting the bean with the constructor binding and accessing them through the injected bean
    @Bean
    FakeDataSource fakeDataSource(ConstructorConfig constructorConfig) {
        FakeDataSource dataSource = new FakeDataSource();
        dataSource.setUsername(constructorConfig.getUsername());
        dataSource.setPassword(constructorConfig.getPassword());
        dataSource.setJdbcURL(constructorConfig.getJdbcURL());
        return dataSource;
    }

    // Using property binding and injecting the bean with the properties binding and accessing them through the injected bean
//    @Bean
//    FakeDataSource fakeDataSource(DependencyInjectionConfig dependencyInjectionConfig) {
//        FakeDataSource dataSource = new FakeDataSource();
//        dataSource.setUsername(dependencyInjectionConfig.getUsername());
//        dataSource.setPassword(dependencyInjectionConfig.getPassword());
//        dataSource.setJdbcURL(dependencyInjectionConfig.getJdbcURL());
//        return dataSource;
//    }

    // Accessing properties by value
//    @Bean
//    FakeDataSource fakeDataSource(@Value("${belueu.username}") String username,
//                                  @Value("${belueu.password}") String password,
//                                  @Value("${belueu.jdbcURL}") String jdbcUrl) {
//        FakeDataSource dataSource = new FakeDataSource();
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setJdbcURL(jdbcUrl);
//        return dataSource;
//    }

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
