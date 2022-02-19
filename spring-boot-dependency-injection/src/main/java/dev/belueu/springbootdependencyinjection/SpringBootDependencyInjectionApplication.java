package dev.belueu.springbootdependencyinjection;

import dev.belueu.springbootdependencyinjection.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBootDependencyInjectionApplication.class, args);

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");

        System.out.println("---Profile Injected Service");
        System.out.println(i18nController.sayGreeting());

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("---Primary Bean Injected Service");
        System.out.println(myController.sayHello());

        System.out.println("---PropertyInjectedController---");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("---SetterInjectedController---");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("---ConstructorInjectedController---");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
    }

}
