package com.perbear.kidwrangler.Model;

import com.perbear.kidwrangler.enumeration.Gender;
import com.perbear.kidwrangler.enumeration.Race;

import javax.persistence.Entity;

@Entity
public class Demographics extends BaseEntity{
    private Gender gender;
    private Race race;
    private String sexualOrientation;
}
