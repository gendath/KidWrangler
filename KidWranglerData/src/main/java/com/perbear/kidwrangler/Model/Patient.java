package com.perbear.kidwrangler.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Patient extends Person{
    @ManyToMany(mappedBy = "children")
    private final List<Parent> parents;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    private Set<Visit> appointments;

    public Patient() {
        this.parents = new ArrayList<>();
        this.appointments = new HashSet<>();
    }



    public List<Parent> getParents() {
        return parents;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
