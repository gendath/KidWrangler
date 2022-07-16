package com.perbear.kidwrangler.Model;

import lombok.*;

import javax.persistence.Entity;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Specialty extends BaseEntity{
    private String description;
    @Builder
    public Specialty(Long Id, String description) {
        super(Id);
        this.description = description;
    }
}
