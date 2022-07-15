package com.perbear.kidwrangler.repositories;

import com.perbear.kidwrangler.Model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    Set<Patient> findPatientsByLastName(String lastName);
}
