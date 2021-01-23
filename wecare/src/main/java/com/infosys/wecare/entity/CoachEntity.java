package com.infosys.wecare.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CoachEntity {
    @Id
    @GeneratedValue(generator = "coach-id-generator")
    @GenericGenerator(name = "coach-id-generator",
            strategy = "com.infosys.wecare.utility.CoachIdGenerator")
    private String coachId;
    private String name;
    private String password;
    private char gender;
    private LocalDate dateOfBirth;
    private long mobileNumber;
    private String speciality;
}
