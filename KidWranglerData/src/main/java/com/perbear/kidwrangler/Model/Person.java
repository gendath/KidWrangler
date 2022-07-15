package com.perbear.kidwrangler.Model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int age;
    @Builder
    public Person(Long Id, String firstName, String lastName, int age) {
        super(Id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
