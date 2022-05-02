package com.perbear.kidwrangler.services;

import com.perbear.kidwrangler.Model.Child;

import java.util.Set;

public interface ChildService {
    Set<Child> findAll();
    Child save(Child child);
    Child findById(Long Id);


}
