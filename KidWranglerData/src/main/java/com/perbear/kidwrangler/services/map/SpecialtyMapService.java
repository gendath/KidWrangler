package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Specialty;
import com.perbear.kidwrangler.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class SpecialtyMapService  extends AbstractMapService<Specialty,Long> implements SpecialtyService {
    private Specialty object;

    @Override
    public Set<Specialty> findByLastName(String lastName) {
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
