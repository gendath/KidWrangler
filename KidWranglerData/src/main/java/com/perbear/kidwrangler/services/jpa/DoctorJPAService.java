package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Doctor;
import com.perbear.kidwrangler.repositories.DoctorRepository;
import com.perbear.kidwrangler.repositories.PatientRepository;
import com.perbear.kidwrangler.repositories.SpecialtyRepository;
import com.perbear.kidwrangler.repositories.VisitRepository;
import com.perbear.kidwrangler.services.DoctorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class DoctorJPAService implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final SpecialtyRepository specialtyRepository;
    private final PatientRepository patientRepository;
    private final VisitRepository visitRepository;

    public DoctorJPAService(DoctorRepository doctorRepository, SpecialtyRepository specialtyRepository, PatientRepository patientRepository, VisitRepository visitRepository) {
        this.doctorRepository = doctorRepository;
        this.specialtyRepository = specialtyRepository;
        this.patientRepository = patientRepository;
        this.visitRepository = visitRepository;
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

        object.getSpecialties().iterator().forEachRemaining((s)->{
            if(s.getId()==null){
                specialtyRepository.save(s);
            }
        });



        object.getAppointments().iterator().forEachRemaining((a)->{
            if(a.getId()==null){
               visitRepository.save(a);
            }
        });
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
