package dev.belueu.springbootpetclinicdata.service.mapservice;

import dev.belueu.springbootpetclinicdata.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(newIdValue());
            }
            map.put(newIdValue(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        if (map.containsValue(object)) {
            map.values().remove(object);
        } else {
            throw new RuntimeException("Object of type: " + object + " not found");
        }
    }

    T findByLastName(String lastName) {
        return map.values().stream().filter(lastName::equals).findFirst().orElse(null);
    }

    Long newIdValue() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }

}
