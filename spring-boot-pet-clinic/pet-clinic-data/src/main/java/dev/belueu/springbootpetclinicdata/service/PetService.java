package dev.belueu.springbootpetclinicdata.service;

import dev.belueu.springbootpetclinicdata.model.Owner;
import dev.belueu.springbootpetclinicdata.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
