package com.perbear.kidwrangler.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@Entity
public class Patient extends Person{
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    @ToString.Exclude
    private Set<Visit> appointments;

    public Patient() {
        this.appointments = new HashSet<>();
    }

}
