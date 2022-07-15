package com.perbear.kidwrangler.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Doctor extends Person{

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "doctor_specialty",joinColumns = @JoinColumn(name = "doctor_id"),inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private final Set<Specialty> specialties;


    public Set<Visit> getAppointments() {
        return appointments;
    }

    @OneToMany(mappedBy = "doctor")
    private Set<Visit> appointments;

    public Doctor() {
        this.specialties = new HashSet<>();
        this.appointments = new HashSet<>();
    }



    public Set<Specialty> getSpecialties() {
        return specialties;
    }
}
