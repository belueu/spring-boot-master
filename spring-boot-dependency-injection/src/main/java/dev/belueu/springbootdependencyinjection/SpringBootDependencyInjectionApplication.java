package dev.belueu.springbootdependencyinjection;

import dev.belueu.springbootdependencyinjection.controller.ConstructorInjectedController;
import dev.belueu.springbootdependencyinjection.controller.MyController;
import dev.belueu.springbootdependencyinjection.controller.PropertyInjectedController;
import dev.belueu.springbootdependencyinjection.controller.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBootDependencyInjectionApplication.class, args);

        MyController myController = (MyController) ctx.getBean("myController");
        String greeting = myController.sayHello();

        System.out.println(greeting);


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
