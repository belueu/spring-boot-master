package dev.belueu.springbootpetclinicweb.bootstrap;

import dev.belueu.springbootpetclinicdata.model.Owner;
import dev.belueu.springbootpetclinicdata.model.Pet;
import dev.belueu.springbootpetclinicdata.model.PetType;
import dev.belueu.springbootpetclinicdata.model.Vet;
import dev.belueu.springbootpetclinicdata.service.OwnerService;
import dev.belueu.springbootpetclinicdata.service.PetTypeService;
import dev.belueu.springbootpetclinicdata.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class BootstrapData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public BootstrapData(OwnerService ownerService,
                         VetService vetService,
                         PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Cat");
        PetType savedDogPetType = petTypeService.save(dog);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Address Street");
        owner1.setCity("Timisoara");
        owner1.setTelephone("1234555");

        Pet mikesPet = new Pet();
        mikesPet.setName("Bandalandabad");
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now().minus(5, ChronoUnit.MONTHS));
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Harley");
        owner2.setAddress("567 Address Street");
        owner2.setCity("Timisoara");
        owner2.setTelephone("1234666");

        Pet johnsPet = new Pet();
        johnsPet.setName("Jakie");
        johnsPet.setPetType(savedDogPetType);
        johnsPet.setOwner(owner2);
        johnsPet.setBirthDate(LocalDate.now().minus(14, ChronoUnit.MONTHS));
        owner2.getPets().add(johnsPet);

        ownerService.save(owner2);

        System.out.println("Loading owners...");
        System.out.println("Number of owners loaded: " + ownerService.findAll().size());

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loading vets...");
        System.out.println("Number of vets loaded: " + vetService.findAll().size());

    }
}
