package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Patient;
import com.perbear.kidwrangler.repositories.PatientRepository;
import com.perbear.kidwrangler.repositories.VisitRepository;
import com.perbear.kidwrangler.services.PatientService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PatientJPAService implements PatientService {

    private final PatientRepository patientRepository;
    private final VisitRepository visitRepository;


    public PatientJPAService(PatientRepository patientRepository, VisitRepository visitRepository) {
        this.patientRepository = patientRepository;
        this.visitRepository = visitRepository;
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

        object.getAppointments().iterator().forEachRemaining(a->{
            if(a.getId()==null){
                visitRepository.save(a);
            }

        });
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
