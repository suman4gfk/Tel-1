package com.infosys.wecare.repository;

import com.infosys.wecare.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookingEntity, Integer> {
    public Optional<BookingEntity> findByUserId(String userId);

    public List<BookingEntity> findBookingByUserId(String userId, LocalDate today);

    public List<BookingEntity> findBookingByCoachId(String coachId, LocalDate today);

    public BookingEntity findAllBookings(String userId, LocalDate appointmentDate, String slot);
}
