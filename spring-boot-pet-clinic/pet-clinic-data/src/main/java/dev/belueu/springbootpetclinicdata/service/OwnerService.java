package dev.belueu.springbootpetclinicdata.service;

import dev.belueu.springbootpetclinicdata.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
