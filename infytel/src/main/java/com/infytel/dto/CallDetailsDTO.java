package com.infytel.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CallDetailsDTO {
    long calledBy;
    long calledTo;
    LocalDate calledOn;
    int duration;
}
