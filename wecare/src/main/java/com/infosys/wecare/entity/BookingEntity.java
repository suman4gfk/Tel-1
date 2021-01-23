package com.infosys.wecare.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingEntity {
    @Id
    private int bookingId;
    private String userId;
    private String coachId;
    private String slot;
    private LocalDate appointmentDate;
}
