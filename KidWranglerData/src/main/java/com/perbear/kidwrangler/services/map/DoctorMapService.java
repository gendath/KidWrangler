package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Doctor;
import com.perbear.kidwrangler.services.DoctorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"default","map"})
public class DoctorMapService extends AbstractMapService<Doctor,Long> implements DoctorService {
    @Override
    public Set<Doctor> findByLastName(String lastName) {
        return this.findAll().stream().filter(object->object.getLastName().equalsIgnoreCase(lastName)).collect(Collectors.toSet());
    }

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
        return super.save(object);
    }

    @Override
    public Doctor findById(Long id) {
        return super.findById(id);
    }
}
