package com.perbear.kidwrangler.Model;

import java.util.Set;

public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private int age;

    private Set<Parent> parents;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
