package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Demographics;
import com.perbear.kidwrangler.Model.Parent;
import com.perbear.kidwrangler.services.DemographicsService;

import java.util.Set;

public class DemographicsMapService  extends AbstractMapService<Demographics,Long> implements DemographicsService {


    @Override
    public Parent findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Demographics> findAll() {
        return super.findAll();
    }

    @Override
    public Demographics findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Demographics save(Demographics object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Demographics object) {
        super.delete(object);

    }
}