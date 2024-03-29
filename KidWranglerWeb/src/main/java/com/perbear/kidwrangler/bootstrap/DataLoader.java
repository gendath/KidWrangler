package com.perbear.kidwrangler.bootstrap;

import com.perbear.kidwrangler.Model.Doctor;
import com.perbear.kidwrangler.Model.Parent;
import com.perbear.kidwrangler.Model.Patient;
import com.perbear.kidwrangler.Model.Specialty;
import com.perbear.kidwrangler.services.DoctorService;
import com.perbear.kidwrangler.services.ParentService;
import com.perbear.kidwrangler.services.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final DoctorService doctorService;
    private final ParentService parentService;
    private final PatientService patientService;

    public DataLoader(DoctorService doctorService, ParentService parentService, PatientService patientService) {
        this.doctorService = doctorService;
        this.parentService = parentService;
        this.patientService = patientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Parent parent1 = new Parent();
        parent1.setFirstName("Perry");
        parent1.setAge(44);
        parent1.setLastName("Shelton");
        parent1.setAddress1("4177 N Palm Ave.");
        parent1.setCity("Fresno");
        parent1.setState("CA");
        parent1.setPhoneNumber(559_859_3964l);
        parentService.save(parent1);


        Parent parent2 = new Parent();
        parent2.setFirstName("Rhonda");
        parent2.setAge(52);
        parent2.setLastName("Shelton");
        parent2.setAddress1("4177 N Palm Ave.");
        parent2.setCity("Fresno");
        parent2.setState("CA");
        parent2.setPhoneNumber(559_859_3964l);
        parentService.save(parent2);

        Doctor doctor1 = new Doctor();
        doctor1.setFirstName("Victor");
        doctor1.setLastName("Frankenstein");
        doctor1.getSpecialties().add(new Specialty("Pediatrics"));
        doctor1.getSpecialties().add(new Specialty("Internal Medicine"));
        doctor1.setAge(65);

        doctorService.save(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setFirstName("The");
        doctor2.setLastName("Doctor");
        doctor2.getSpecialties().add(new Specialty("Pediatrics"));
        doctor2.getSpecialties().add(new Specialty("Euthanasia"));
        doctor2.setAge(912);

        doctorService.save(doctor2);

        Patient patient1 = new Patient();
        patient1.setFirstName("William");
        patient1.setLastName("Shelton");
        patient1.setAge(9);
        parent1.getChildren().add(patient1);
        parent2.getChildren().add(patient1);
        patientService.save(patient1);

        Patient patient2 = new Patient();
        patient2.setFirstName("Stephen");
        patient2.setLastName("Shelton");
        patient2.setAge(21);
        parent1.getChildren().add(patient2);
        parent2.getChildren().add(patient2);
        patientService.save(patient2);

        parentService.save(parent1);
        parentService.save(parent2);

    }
}
