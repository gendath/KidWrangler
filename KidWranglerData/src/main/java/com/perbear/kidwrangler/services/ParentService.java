package com.perbear.kidwrangler.services;

import com.perbear.kidwrangler.Model.Parent;

import java.util.Set;

public interface ParentService {
    Parent findByLastName(String lastName);
    Parent findById(Long Id);
    Parent save(Parent parent);
    Set<Parent> findAll();

}
