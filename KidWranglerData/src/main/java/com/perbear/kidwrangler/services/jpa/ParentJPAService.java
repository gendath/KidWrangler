package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Parent;
import com.perbear.kidwrangler.repositories.*;
import com.perbear.kidwrangler.services.ParentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
public class ParentJPAService implements ParentService {

    private final ParentRepository parentRepository;
    private final DoctorRepository doctorRepository;
    private final VisitRepository visitRepository;
    private final DemographicsRepository demographicsRepository;
    private final SpecialtyRepository specialtyRepository;
    private  final PatientRepository patientRepository;

    public ParentJPAService(ParentRepository parentRepository, DoctorRepository doctorRepository,
                            VisitRepository visitRepository, DemographicsRepository demographicsRepository,
                            SpecialtyRepository specialtyRepository, PatientRepository patientRepository) {
        this.parentRepository = parentRepository;
        this.doctorRepository = doctorRepository;
        this.visitRepository = visitRepository;
        this.demographicsRepository = demographicsRepository;
        this.specialtyRepository = specialtyRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Set<Parent> findByLastName(String lastName) {
        return parentRepository.findParentsByLastName(lastName);
    }

    @Override
    public Set<Parent> findAll() {
        Set<Parent> parents = new HashSet<>();

        parentRepository.findAll().iterator().forEachRemaining(parents::add);

        return parents;
    }

    @Override
    public Parent findById(Long id) {

        return parentRepository.findById(id).orElse(null);

    }

    @Override
    public Parent save(Parent object) {
        return parentRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        parentRepository.deleteById(id);

    }

    @Override
    public void delete(Parent object) {
        parentRepository.delete(object);

    }
}
