package dev.belueu.springbootpetclinicweb.bootstrap;

import dev.belueu.springbootpetclinicdata.model.Owner;
import dev.belueu.springbootpetclinicdata.model.Vet;
import dev.belueu.springbootpetclinicdata.service.OwnerService;
import dev.belueu.springbootpetclinicdata.service.VetService;
import dev.belueu.springbootpetclinicdata.service.mapservice.OwnerMapService;
import dev.belueu.springbootpetclinicdata.service.mapservice.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public BootstrapData() {
        this.ownerService = new OwnerMapService();
        this.vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Michael");
        owner2.setLastName("Weston");

        ownerService.save(owner2);

        System.out.println("Loading owners...");
        System.out.println("Number of owners loaded: " + ownerService.findAll().size());

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loading vets...");
        System.out.println("Number of vets loaded: " + vetService.findAll().size());

    }
}
