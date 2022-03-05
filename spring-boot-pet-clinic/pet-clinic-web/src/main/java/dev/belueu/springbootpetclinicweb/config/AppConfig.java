package dev.belueu.springbootpetclinicweb.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"dev.belueu.springbootpetclinicdata", "dev.belueu.springbootpetclinicweb"})
@EntityScan("dev.belueu.springbootpetclinicdata.model")
@EnableJpaRepositories("dev.belueu.springbootpetclinicdata.repository")
public class AppConfig {
}
