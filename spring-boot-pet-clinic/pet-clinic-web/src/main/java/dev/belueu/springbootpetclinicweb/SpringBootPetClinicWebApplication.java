package dev.belueu.springbootpetclinicweb;

import dev.belueu.springbootpetclinicdata.service.OwnerService;
import dev.belueu.springbootpetclinicdata.service.PetService;
import dev.belueu.springbootpetclinicdata.service.PetTypeService;
import dev.belueu.springbootpetclinicdata.service.VetService;
import dev.belueu.springbootpetclinicdata.service.mapservice.OwnerMapService;
import dev.belueu.springbootpetclinicdata.service.mapservice.PetMapService;
import dev.belueu.springbootpetclinicdata.service.mapservice.PetTypeMapService;
import dev.belueu.springbootpetclinicdata.service.mapservice.VetMapService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootPetClinicWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPetClinicWebApplication.class, args);
    }

    @Bean
    OwnerService ownerService() {
        return new OwnerMapService(petTypeService(), petService());
    }

    @Bean
    PetService petService() {
        return new PetMapService();
    }

    @Bean
    VetService vetService() {
        return new VetMapService();
    }

    @Bean
    PetTypeService petTypeService() {
        return new PetTypeMapService();
    }
}
