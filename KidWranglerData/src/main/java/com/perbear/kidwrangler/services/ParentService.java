package com.perbear.kidwrangler.services;

import com.perbear.kidwrangler.Model.Parent;

public interface ParentService extends CrudService<Parent,Long> {
    Parent findByLastName(String lastName);
}
