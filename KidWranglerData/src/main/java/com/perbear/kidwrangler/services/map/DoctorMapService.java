package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Doctor;
import com.perbear.kidwrangler.services.CrudService;

import java.util.Set;

public class DoctorMapService extends AbstractMapService<Doctor,Long> implements CrudService<Doctor,Long> {
    @Override
    public Set<Doctor> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Doctor object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Doctor save(Doctor object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Doctor findById(Long id) {
        return super.findById(id);
    }
}
