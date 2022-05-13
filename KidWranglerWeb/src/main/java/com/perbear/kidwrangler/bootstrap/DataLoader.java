package com.perbear.kidwrangler.bootstrap;

import com.perbear.kidwrangler.Model.Doctor;
import com.perbear.kidwrangler.Model.Parent;
import com.perbear.kidwrangler.services.DoctorService;
import com.perbear.kidwrangler.services.ParentService;
import com.perbear.kidwrangler.services.PatientService;
import com.perbear.kidwrangler.services.map.DoctorMapService;
import com.perbear.kidwrangler.services.map.ParentMapService;
import com.perbear.kidwrangler.services.map.PatientMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final DoctorService doctorService;
    private final ParentService parentService;
    private final PatientService patientService;

    public DataLoader() {
        doctorService = new DoctorMapService();
        parentService = new ParentMapService();
        patientService = new PatientMapService();
    }

    @Override
    public void run(String... args) throws Exception {
        Parent parent = new Parent();
        parent.setId(1l);
        parent.setFirstName("Perry");
        parent.setAge(44);
        parent.setLastName("Shelton");
        parentService.save(parent);


        parent = new Parent();
        parent.setId(2l);
        parent.setFirstName("Rhonda");
        parent.setAge(52);
        parent.setLastName("Shelton");
        parentService.save(parent);

        Doctor doctor = new Doctor();
        doctor.setId(3l);
        doctor.setFirstName("Victor");
        doctor.setLastName("Frankenstein");
        doctor.setAge(65);

        doctorService.save(doctor);

        doctor = new Doctor();
        doctor.setId(4l);
        doctor.setFirstName("The");
        doctor.setLastName("Doctor");
        doctor.setAge(912);

        doctorService.save(doctor);


    }
}
