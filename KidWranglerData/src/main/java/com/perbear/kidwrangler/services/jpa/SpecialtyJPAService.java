package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Specialty;
import com.perbear.kidwrangler.repositories.SpecialtyRepository;
import com.perbear.kidwrangler.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
public class SpecialtyJPAService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyJPAService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().iterator().forEachRemaining(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);

    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);

    }
}
