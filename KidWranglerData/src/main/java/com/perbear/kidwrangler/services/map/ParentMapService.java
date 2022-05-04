package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Parent;
import com.perbear.kidwrangler.services.CrudService;

import java.util.Set;

public class ParentMapService extends AbstractMapService<Parent,Long> implements CrudService<Parent,Long> {
    @Override
    public Set<Parent> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Parent object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Parent save(Parent object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Parent findById(Long id) {
        return super.findById(id);
    }
}
