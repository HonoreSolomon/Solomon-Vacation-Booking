package com.solomon.vacation_booking.services;


import com.solomon.vacation_booking.dto.Purchase;
import com.solomon.vacation_booking.dto.PurchaseResponse;



public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
