package dev.belueu.springbootdependencyinjection;

import dev.belueu.springbootdependencyinjection.config.AppConfig;
import dev.belueu.springbootdependencyinjection.controller.*;
import dev.belueu.springbootdependencyinjection.service.PrototypeBean;
import dev.belueu.springbootdependencyinjection.service.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;


public class SpringBootDependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AppConfig.class, args);

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());


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

        System.out.println("---Bean Scope---");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());
    }
}

