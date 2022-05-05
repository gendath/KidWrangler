package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Patient;
import com.perbear.kidwrangler.services.CrudService;

import java.util.Set;

public class ChildMapService extends AbstractMapService<Patient,Long> implements CrudService<Patient,Long> {
    @Override
    public Set<Patient> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Patient object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Patient save(Patient object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Patient findById(Long id) {
        return super.findById(id);
    }
}
