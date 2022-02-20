package dev.belueu.springbootpetclinicdata.service;

import dev.belueu.springbootpetclinicdata.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
