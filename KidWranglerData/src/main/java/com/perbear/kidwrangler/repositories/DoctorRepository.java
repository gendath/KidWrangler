package com.perbear.kidwrangler.repositories;

import com.perbear.kidwrangler.Model.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Set<Doctor> findDoctorsByLastName(String lastName);


}
