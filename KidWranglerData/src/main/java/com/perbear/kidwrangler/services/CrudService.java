package com.perbear.kidwrangler.services;

import com.perbear.kidwrangler.Model.Parent;

import java.util.Set;

public interface CrudService<T,ID> {

    Parent findByLastName(String lastName);
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void deleteById(ID id);
    void delete(T object);
}
