package com.perbear.kidwrangler.services;

import com.perbear.kidwrangler.Model.Doctor;

import java.util.Set;

public interface DoctorService {
    Doctor findById(Long Id);
    Doctor save(Doctor doctor);
    Set<Doctor> findAll();
}
