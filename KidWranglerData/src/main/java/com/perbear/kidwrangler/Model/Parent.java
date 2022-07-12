package com.perbear.kidwrangler.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Parent extends Person{
    @ManyToMany
    @JoinTable(name = "parent_child",joinColumns = @JoinColumn(name = "parent_id"),inverseJoinColumns = @JoinColumn(name = "child_id"))
    private final Set<Patient> children;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Long phoneNumber;

    public Parent() {
        this.children = new HashSet<>();
    }

    public Set<Patient> getChildren() {
        return children;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
