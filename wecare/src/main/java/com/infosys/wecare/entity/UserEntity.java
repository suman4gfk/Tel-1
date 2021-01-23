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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(generator = "user-id-generator")
    @GenericGenerator(name = "user-id-generator",
            strategy = "com.infosys.wecare.utility.UserIdGenerator")
    private String userId;
    private String name;
    private String password;
    private char gender;
    private LocalDate dateOfBirth;
    private long mobileNumber;
    private String email;
    private int pincode;
    private String city;
    private String state;
    private String country;
}
