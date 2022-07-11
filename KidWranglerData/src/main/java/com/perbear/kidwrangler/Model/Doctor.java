package com.perbear.kidwrangler.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Doctor extends Person{
    private final List<Patient> patients;
    private final Set<Specialty> specialties;

    public Doctor() {
        this.patients = new ArrayList<>();
        this.specialties = new HashSet<>();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }
}
