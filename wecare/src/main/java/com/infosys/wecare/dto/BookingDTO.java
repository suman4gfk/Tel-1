package com.infosys.wecare.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDTO {

    private int bookingId;
    private String userId;
    private String coachId;
    private LocalDate appointmentDate;
    private char slot;
}
