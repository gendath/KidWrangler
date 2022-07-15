package com.perbear.kidwrangler.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@SuperBuilder
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

}
