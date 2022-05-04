package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Child;
import com.perbear.kidwrangler.services.CrudService;

import java.util.Set;

public class ChildMapService extends AbstractMapService<Child,Long> implements CrudService<Child,Long> {
    @Override
    public Set<Child> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Child object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Child save(Child object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Child findById(Long id) {
        return super.findById(id);
    }
}
