package com.solomon.vacation_booking.dao;

import com.solomon.vacation_booking.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}

