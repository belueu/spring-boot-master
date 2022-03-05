package dev.belueu.springbootpetclinicdata.service.datajpaservice;

import dev.belueu.springbootpetclinicdata.model.Pet;
import dev.belueu.springbootpetclinicdata.repository.PetRepo;
import dev.belueu.springbootpetclinicdata.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservice")
public class PetJpaService implements PetService {

    private final PetRepo petRepo;

    public PetJpaService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public Set<Pet> findAll() {
        return new HashSet<>(petRepo.findAll());
    }

    @Override
    public Pet findById(Long id) {
        return petRepo.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepo.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepo.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepo.deleteById(id);
    }
}
