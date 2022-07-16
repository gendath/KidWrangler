package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Parent;
import com.perbear.kidwrangler.services.ParentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"default","map"})

public class ParentMapService extends AbstractMapService<Parent,Long> implements ParentService {
    @Override
    public Set<Parent> findByLastName(String lastName) {
        return this.findAll().stream().filter(object->object.getLastName().equalsIgnoreCase(lastName)).collect(Collectors.toSet());
    }

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
        return super.save(object);
    }

    @Override
    public Parent findById(Long id) {
        return super.findById(id);
    }
}
