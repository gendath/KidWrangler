package com.perbear.kidwrangler.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient extends Person{


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    private Set<Visit> appointments;

    public Set<Visit> getAppointments() {
        return appointments;
    }

    public Patient() {
        this.appointments = new HashSet<>();
    }

}
