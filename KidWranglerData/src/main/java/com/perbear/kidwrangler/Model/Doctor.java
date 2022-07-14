package com.perbear.kidwrangler.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
public class Doctor extends Person{
    @OneToMany(mappedBy = "doctor")
    private final List<Patient> patients;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "doctor_specialty",joinColumns = @JoinColumn(name = "doctor_id"),inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private final Set<Specialty> specialties;


    @OneToMany(mappedBy = "doctor")
    private Set<Visit> appointments;

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
