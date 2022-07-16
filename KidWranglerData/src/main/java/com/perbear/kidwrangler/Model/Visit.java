package com.perbear.kidwrangler.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Visit extends BaseEntity{
    private LocalDate date;
    private String Description;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Builder
    public Visit(Long Id, LocalDate date, String description, Patient patient, Doctor doctor) {
        super(Id);
        this.date = date;
        Description = description;
        this.patient = patient;
        this.doctor = doctor;
    }
}
