package com.infosys.wecare.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UserDTO {

    private String coachId;
    @NotNull(message = "")
    @Min(value = 5, message = "")
    @Max(value = 10, message = "")
    private String password;
    @NotNull(message = "")
    @Min(value = 3, message = "")
    @Max(value = 50, message = "")
    private String name;
    private LocalDate dateOfBirth;
    private char gender;
    @NotNull(message = "")
    @Min(value = 10, message = "")
    @Max(value = 10, message = "")
    private long mobileNumber;
    @Email(message = "")
    private String email;
    @NotNull(message = "")
    @Min(value = 6, message = "")
    @Max(value = 6, message = "")
    private int pincode;
    @NotNull(message = "")
    @Min(value = 3, message = "")
    @Max(value = 20, message = "")
    private String city;
    @NotNull(message = "")
    @Min(value = 3, message = "")
    @Max(value = 20, message = "")
    private String state;
    @NotNull(message = "")
    @Min(value = 3, message = "")
    @Max(value = 20, message = "")
    private String country;

}
