package dev.belueu.springbootpetclinicdata.service;

import dev.belueu.springbootpetclinicdata.model.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Page<Owner> findByLastName(String lastName, Pageable pageable);

    List<Owner> findAllByLastNameLike(String lastName);
}
