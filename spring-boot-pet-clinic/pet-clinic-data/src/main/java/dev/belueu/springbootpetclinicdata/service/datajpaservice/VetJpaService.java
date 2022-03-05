package dev.belueu.springbootpetclinicdata.service.datajpaservice;

import dev.belueu.springbootpetclinicdata.model.Vet;
import dev.belueu.springbootpetclinicdata.repository.VetRepo;
import dev.belueu.springbootpetclinicdata.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservice")
public class VetJpaService implements VetService {

    private final VetRepo vetRepo;

    public VetJpaService(VetRepo vetRepo) {
        this.vetRepo = vetRepo;
    }

    @Override
    public Set<Vet> findAll() {
        return new HashSet<>(vetRepo.findAll());
    }

    @Override
    public Vet findById(Long id) {
        return vetRepo.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepo.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepo.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepo.deleteById(id);
    }
}

