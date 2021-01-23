package com.infy.infytel2.dto;

import lombok.Data;

@Data
public class PlanDTO {
    Integer planId;
    String planName;
    Integer nationalRate;
    Integer localRate;
}
