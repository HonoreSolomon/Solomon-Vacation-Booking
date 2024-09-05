package com.solomon.vacation_booking.dto;

import com.solomon.vacation_booking.entities.Cart;
import com.solomon.vacation_booking.entities.CartItem;
import com.solomon.vacation_booking.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
