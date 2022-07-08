package com.perbear.kidwrangler.Model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person{
    private final List<Parent> parents;
    private Doctor doctor;

    public Patient() {
        this.parents = new ArrayList<>();
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
