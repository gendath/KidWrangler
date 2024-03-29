package com.perbear.kidwrangler.Model;

import com.perbear.kidwrangler.enumeration.Gender;
import com.perbear.kidwrangler.enumeration.Race;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Demographics extends BaseEntity{
    private Gender gender;
    private Race race;
    private String sexualOrientation;
    @Builder
    public Demographics(Long Id, Gender gender, Race race, String sexualOrientation) {
        super(Id);
        this.gender = gender;
        this.race = race;
        this.sexualOrientation = sexualOrientation;
    }
}
