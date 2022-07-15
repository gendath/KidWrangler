package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Patient;
import com.perbear.kidwrangler.repositories.PatientRepository;
import com.perbear.kidwrangler.services.PatientService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
public class PatientJPAService implements PatientService {

    private final PatientRepository patientRepository;

    public PatientJPAService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Set<Patient> findByLastName(String lastName) {
        return patientRepository.findPatientsByLastName(lastName);
    }

    @Override
    public Set<Patient> findAll() {
        Set<Patient> patients = new HashSet<>();
        patientRepository.findAll().iterator().forEachRemaining(patients::add);

        return patients;
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient save(Patient object) {
        return patientRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);

    }

    @Override
    public void delete(Patient object) {
        patientRepository.delete(object);

    }
}
