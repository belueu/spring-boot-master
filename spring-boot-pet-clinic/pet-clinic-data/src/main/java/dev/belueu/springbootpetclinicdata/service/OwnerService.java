package dev.belueu.springbootpetclinicdata.service;

import dev.belueu.springbootpetclinicdata.model.Owner;

import java.util.Optional;

public interface OwnerService extends CrudService<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);
}
