package dev.belueu.springbootpetclinicweb;

import dev.belueu.springbootpetclinicdata.service.*;
import dev.belueu.springbootpetclinicdata.service.mapservice.*;
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
        return new VetMapService(specialityService());
    }

    @Bean
    PetTypeService petTypeService() {
        return new PetTypeMapService();
    }

    @Bean
    SpecialityService specialityService() {
        return new SpecialityMapService();
    }
}
