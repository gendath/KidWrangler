package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Parent;
import com.perbear.kidwrangler.Model.Specialty;
import com.perbear.kidwrangler.services.SpecialtyService;

import java.util.Set;

public class SpecialtyMapService  extends AbstractMapService<Specialty,Long> implements SpecialtyService {
    private Specialty object;

    @Override
    public Parent findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }



    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);

    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}