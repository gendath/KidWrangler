package com.perbear.kidwrangler.Model;

import java.util.List;
import java.util.Set;

public class Doctor extends Person{
    private List<Patient> patients;
    private Set<Specialty> specialties;
}
