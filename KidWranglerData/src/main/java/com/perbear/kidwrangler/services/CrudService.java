package com.perbear.kidwrangler.services;

import java.util.Set;

public interface CrudService<T,ID> {

    Set<T> findByLastName(String lastName);
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void deleteById(ID id);
    void delete(T object);
}
