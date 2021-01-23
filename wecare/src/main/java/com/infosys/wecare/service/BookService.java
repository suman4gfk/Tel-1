package com.infosys.wecare.service;

import com.infosys.wecare.dto.BookingDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    public boolean bookAppointment(String userId, String coachId, LocalDate appointmentDate, String slot) {
        return false;
    }

    public boolean rescheduleAppointment(Integer bookingId, LocalDate appointmentDate, String slot) {
        return false;
    }

    public void cancelAppointment(Integer bookingId) {

    }

    public BookingDTO findByBookingId(Integer bookingId) {
        return null;
    }

    public List<BookingDTO> findBookingByUserId(String userId) {
        return null;
    }

    public List<BookingDTO> findBookingByCoachId(String coachId) {
        return null;
    }
}
