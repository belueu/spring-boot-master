package dev.belueu.springbootpetclinicdata.service.datajpaservice;

import dev.belueu.springbootpetclinicdata.model.Visit;
import dev.belueu.springbootpetclinicdata.repository.VisitRepo;
import dev.belueu.springbootpetclinicdata.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservice")
public class VisitJpaService implements VisitService {

    private final VisitRepo visitRepo;

    public VisitJpaService(VisitRepo visitRepo) {
        this.visitRepo = visitRepo;
    }

    @Override
    public Set<Visit> findAll() {
        return new HashSet<>(visitRepo.findAll());
    }

    @Override
    public Visit findById(Long id) {
        return visitRepo.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepo.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepo.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepo.deleteById(id);
    }
}
