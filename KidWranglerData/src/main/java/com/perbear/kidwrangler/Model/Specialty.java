package com.perbear.kidwrangler.Model;

import javax.persistence.Entity;

@Entity
public class Specialty extends BaseEntity{
    private String description;

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
