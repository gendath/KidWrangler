package com.perbear.kidwrangler.repositories;

import com.perbear.kidwrangler.Model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
