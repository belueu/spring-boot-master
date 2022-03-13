package dev.belueu.springbootpetclinicdata.service.datajpaservice;

import dev.belueu.springbootpetclinicdata.model.Owner;
import dev.belueu.springbootpetclinicdata.repository.OwnerRepo;
import dev.belueu.springbootpetclinicdata.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("jpaservice")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepo ownerRepo;

    public OwnerJpaService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public Set<Owner> findAll() {
        return new HashSet<>(ownerRepo.findAll());
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepo.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepo.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepo.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepo.deleteById(id);
    }

    @Override
    public Page<Owner> findByLastName(String lastName, Pageable pageable) {
        return ownerRepo.findByLastName(lastName, pageable);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepo.findAllByLastNameLike(lastName);
    }
}
