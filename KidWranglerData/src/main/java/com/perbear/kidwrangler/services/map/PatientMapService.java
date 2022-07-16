package com.perbear.kidwrangler.services.map;

import com.perbear.kidwrangler.Model.Patient;
import com.perbear.kidwrangler.services.PatientService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"default","map"})
public class PatientMapService extends AbstractMapService<Patient,Long> implements PatientService {
    @Override
    public Set<Patient> findByLastName(String lastName) {
        return this.findAll().stream().filter(object->object.getLastName().equalsIgnoreCase(lastName)).collect(Collectors.toSet());
    }

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
        return super.save(object);
    }

    @Override
    public Patient findById(Long id) {
        return super.findById(id);
    }
}
