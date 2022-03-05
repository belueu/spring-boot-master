package dev.belueu.springbootpetclinicweb.bootstrap;

import dev.belueu.springbootpetclinicdata.model.*;
import dev.belueu.springbootpetclinicdata.service.OwnerService;
import dev.belueu.springbootpetclinicdata.service.PetTypeService;
import dev.belueu.springbootpetclinicdata.service.SpecialityService;
import dev.belueu.springbootpetclinicdata.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public BootstrapData(OwnerService ownerService,
                         VetService vetService,
                         PetTypeService petTypeService,
                         SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {

            loadData();
        }
    }

    private void loadData() {
        PetType cat = PetType.builder().name("Cat").build();
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = PetType.builder().name("Dog").build();
        PetType savedDogPetType = petTypeService.save(dog);

        Speciality radiology = Speciality.builder().description("Radiology").build();
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = Speciality.builder().description("Surgery").build();
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = Speciality.builder().description("Dentistry").build();
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = Owner.builder()
                .firstName("Michael")
                .lastName("Weston")
                .address("123 Address Street")
                .city("Timisoara")
                .telephone("1234555")
                .pets(new HashSet<>(List.of()))
                .build();

        Pet mikesPet = Pet.builder()
                .name("Bandalandabad")
                .birthDate(LocalDate.now().minus(5, ChronoUnit.MONTHS))
                .petType(savedCatPetType)
                .owner(owner1)
                .build();

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = Owner.builder()
                .firstName("John")
                .lastName("Harley")
                .address("567 Address Street")
                .city("Timisoara")
                .telephone("1234666")
                .pets(new HashSet<>(List.of()))
                .build();

        Pet johnsPet = Pet.builder()
                .name("Jakie")
                .birthDate(LocalDate.now().minus(14, ChronoUnit.MONTHS))
                .petType(savedDogPetType)
                .owner(owner2)
                .build();

        owner2.getPets().add(johnsPet);

        ownerService.save(owner2);

        System.out.println("Loading owners...");
        System.out.println("Number of owners loaded: " + ownerService.findAll().size());

        Vet vet1 = Vet.builder()
                .firstName("Sam")
                .lastName("Axe")
                .specialities(new HashSet<>(List.of(savedRadiology)))
                .build();

        vetService.save(vet1);

        Vet vet2 = Vet.builder()
                .firstName("Jessie")
                .lastName("Porter")
                .specialities(new HashSet<>(List.of(savedSurgery)))
                .build();

        vetService.save(vet2);

        System.out.println("Loading vets...");
        System.out.println("Number of vets loaded: " + vetService.findAll().size());
    }
}
