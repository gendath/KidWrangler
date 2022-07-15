package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Doctor;
import com.perbear.kidwrangler.repositories.DoctorRepository;
import com.perbear.kidwrangler.services.DoctorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
public class DoctorJPAService implements DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorJPAService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Set<Doctor> findByLastName(String lastName) {
        return doctorRepository.findDoctorsByLastName(lastName);
    }

    @Override
    public Set<Doctor> findAll() {

        Set<Doctor> doctors = new HashSet<>();
        doctorRepository.findAll().iterator().forEachRemaining(doctors::add);

        return doctors;
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor save(Doctor object) {
        return doctorRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.deleteById(id);

    }

    @Override
    public void delete(Doctor object) {
        doctorRepository.delete(object);

    }
}
