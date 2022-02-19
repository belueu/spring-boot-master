package dev.belueu.springbootdependencyinjection;

import dev.belueu.springbootdependencyinjection.controller.MyController;
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
    }

}
