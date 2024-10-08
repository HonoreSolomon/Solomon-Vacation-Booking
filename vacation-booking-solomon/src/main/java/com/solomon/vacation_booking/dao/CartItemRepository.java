package com.solomon.vacation_booking.dao;

import com.solomon.vacation_booking.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}

