package com.perbear.kidwrangler.Model;

import lombok.*;

import javax.persistence.Entity;
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Specialty extends BaseEntity{
    private String description;
}
