package dev.belueu.springbootpetclinicdata.service.mapservice;

import dev.belueu.springbootpetclinicdata.service.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> implements CrudService<T, ID> {

    protected Map<ID, T> map  = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T object) {
        return map.put(newIdValue(), object);
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T object) {
        if (map.containsValue(object)) {
            map.values().remove(object);
        }
        else {
            throw new RuntimeException("Object of type: " + object + " not found");
        }
    }

    private ID newIdValue() {
        return (ID) (Long) (map.values().stream().count() + 1);
    }

}
