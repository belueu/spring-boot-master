# Maven Multi-Module Project

## spring-boot-web-app

    This app is a basic MVC web app example that makes use of the following dependencies:

- Spring Boot Web
- Spring Boot JPA
- Spring Boot H2
- Spring Boot Thymeleaf

## spring-boot-pet-clinic

    This app is an example of the clasic spring pet clinic implementation and makes use of the following dependencies:

- Spring Boot Actuator
- Spring Boot Web
- Spring Boot JPA
- Spring Boot H2
- Spring Boot Thymeleaf
- Spring Boot MySql
- Spring Boot Devtools
- Lombok

## spring-boot-dependency-injection

    This app shows examples of dependency injection as it is in the core of spring framework, no dependencies needed.

#### Examples of using the following annotations(@):

- @Qualifier
- @Primary
- @Profile
- @PostConstruct
- @PreDestroy
- @ComponentScan
- @Configuration
- @Bean
- @Scope
- @ImportResource
- @PropertySource

#### Setting Environment Variables:

![](spring-boot-dependency-injection/src/main/resources/assets/Screenshot%202022-02-21%20at%2003.05.33.png)

#### Setting Command Line Variables:

![](spring-boot-dependency-injection/src/main/resources/assets/Screenshot%202022-02-21%20at%2003.05.57.png)

#### Spring Boot Application Properties:

    This can be done by setting the variables inside the spring boot application.properties file like so:

- Remove the @PropertySource from GreetingServiceConfig
- Remove the datasource.properties file (no longer needed)
- Remove any Command line arguments or Environment variables previously set
- Spring Boot context will pick up the value directly from the application.properties file

![](spring-boot-dependency-injection/src/main/resources/assets/Screenshot%202022-02-21%20at%2003.26.42.png)

#### Setting up specific profiles for different environments:

    This can be set using .properties files

- Create specific .properties file for each environment

![](spring-boot-dependency-injection/src/main/resources/assets/Screenshot%202022-02-22%20at%2011.02.55.png)

- Spring will pick up the properties from the file based on the active profile settings

![](spring-boot-dependency-injection/src/main/resources/assets/Screenshot%202022-02-22%20at%2011.15.03.png)

- To enable the profile add it to spring.profiles.active

![](spring-boot-dependency-injection/src/main/resources/assets/Screenshot%202022-02-22%20at%2011.26.24.png)

## spring-boot-chuck-norris

    This app displayes random Chuck Norris jokes and makes use of the following dependencies"

- Spring Boot Web
- Spring Boot Thymeleaf