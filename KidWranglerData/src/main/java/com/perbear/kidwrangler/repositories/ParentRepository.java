package com.perbear.kidwrangler.repositories;

import com.perbear.kidwrangler.Model.Parent;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ParentRepository extends CrudRepository<Parent, Long> {
    Set<Parent> findParentsByLastName(String lastName);
}
