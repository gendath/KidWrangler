package com.perbear.kidwrangler.Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
public class Doctor extends Person{

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "doctor_specialty",joinColumns = @JoinColumn(name = "doctor_id"),inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private final Set<Specialty> specialties;


    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private Set<Visit> appointments;

    public Doctor() {
        this.specialties = new HashSet<>();
        this.appointments = new HashSet<>();
    }
@Builder
    public Doctor(Long Id, String firstName, String lastName, int age) {
        super(Id, firstName, lastName, age);
    this.specialties = new HashSet<>();
    this.appointments = new HashSet<>();
    }
}
