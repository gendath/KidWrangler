package com.perbear.kidwrangler.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Specialty extends BaseEntity{
    private String description;
    @ManyToMany(mappedBy = "specialties")
    private Set<Doctor> doctors;

    public Specialty() {
    }

    public Specialty(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
