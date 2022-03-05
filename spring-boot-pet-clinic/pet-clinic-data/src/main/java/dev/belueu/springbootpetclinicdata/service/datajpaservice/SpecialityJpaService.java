package dev.belueu.springbootpetclinicdata.service.datajpaservice;

import dev.belueu.springbootpetclinicdata.model.Speciality;
import dev.belueu.springbootpetclinicdata.repository.SpecialityRepo;
import dev.belueu.springbootpetclinicdata.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservice")
public class SpecialityJpaService implements SpecialityService {

    private final SpecialityRepo specialityRepo;

    public SpecialityJpaService(SpecialityRepo specialityRepo) {
        this.specialityRepo = specialityRepo;
    }

    @Override
    public Set<Speciality> findAll() {
        return new HashSet<>(specialityRepo.findAll());
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepo.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepo.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepo.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepo.deleteById(id);
    }
}
