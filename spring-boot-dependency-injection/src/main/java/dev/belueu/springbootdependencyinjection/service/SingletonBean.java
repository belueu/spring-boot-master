package dev.belueu.springbootdependencyinjection.service;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Singleton Bean created...");
    }

    public String getMyScope() {
        return "Singleton Bean";
    }
}
