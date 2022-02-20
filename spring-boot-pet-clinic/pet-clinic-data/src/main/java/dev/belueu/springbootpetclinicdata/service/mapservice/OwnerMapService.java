package dev.belueu.springbootpetclinicdata.service.mapservice;

import dev.belueu.springbootpetclinicdata.model.Owner;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}