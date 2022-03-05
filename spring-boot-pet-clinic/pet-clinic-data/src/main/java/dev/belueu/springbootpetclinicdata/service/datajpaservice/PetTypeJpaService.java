package dev.belueu.springbootpetclinicdata.service.datajpaservice;

import dev.belueu.springbootpetclinicdata.model.PetType;
import dev.belueu.springbootpetclinicdata.repository.PetTypeRepo;
import dev.belueu.springbootpetclinicdata.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservice")
public class PetTypeJpaService implements PetTypeService {

    private final PetTypeRepo petTypeRepo;

    public PetTypeJpaService(PetTypeRepo petTypeRepo) {
        this.petTypeRepo = petTypeRepo;
    }

    @Override
    public Set<PetType> findAll() {
        return new HashSet<>(petTypeRepo.findAll());
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepo.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepo.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepo.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepo.deleteById(id);
    }
}
