package com.perbear.kidwrangler.Model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
public class Patient extends Person{
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    @ToString.Exclude
    private Set<Visit> appointments;

    public Patient() {
        this.appointments = new HashSet<>();
    }
    @Builder
    public Patient(Long Id, String firstName, String lastName, int age) {
        super(Id, firstName, lastName, age);
        this.appointments = new HashSet<>();
    }
}
