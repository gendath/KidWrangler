package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Visit;
import com.perbear.kidwrangler.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {
    @Override
    public Set<Visit> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Visit save(Visit object) {
        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);

    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
