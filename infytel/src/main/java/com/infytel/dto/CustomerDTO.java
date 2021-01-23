package com.infytel.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class CustomerDTO {

    @NotBlank(message = "{customer.name.must}")
    private String name;
    private String address;
    @Min(value = 18, message = "{customer.age.invalid}")
    @Max(value = 60, message = "{customer.age.invalid}")
    private int age;
    private char gender;
    @NotNull(message = "{customer.email.must}")
    @Email(message = "{customer.email.invalid}")
    private String email;
    //Password should comprise of alphabets of both the cases and digits as well with a length of minimum 5
    @NotEmpty(message = "{customer.password.must}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$", message = "{customer.password.invalid}")
    private String password;
    @NotNull(message = "{customer.phone.must}")
    private long phoneNo;
    @NotNull(message = "{customer.plan.must}")
    private PlanDTO currentPlan;
    private List<FriendsFamilyDTO> friendsFamilyDTO;
}
