package com.perbear.kidwrangler.Model;

import java.time.LocalDate;

public class Visit extends BaseEntity{
    private LocalDate date;
    private String Description;
    private Patient patient;

    public Visit() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
