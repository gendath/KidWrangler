package com.perbear.kidwrangler.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parent extends Person{
    @ManyToMany
    @JoinTable(name = "parent_child",joinColumns = @JoinColumn(name = "parent_id"),inverseJoinColumns = @JoinColumn(name = "child_id"))
    @ToString.Exclude
    private final Set<Patient> children = new HashSet<>();
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Long phoneNumber;
    @Builder
    public Parent(Long Id, String firstName, String lastName, int age, String address1, String address2, String city, String state, Long phoneNumber) {
        super(Id, firstName, lastName, age);
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;


}}
