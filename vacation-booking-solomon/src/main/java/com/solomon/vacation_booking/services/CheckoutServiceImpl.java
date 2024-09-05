package com.solomon.vacation_booking.services;

import com.solomon.vacation_booking.dao.CustomerRepository;
import com.solomon.vacation_booking.dao.CartRepository;
import com.solomon.vacation_booking.dto.Purchase;
import com.solomon.vacation_booking.dto.PurchaseResponse;
import com.solomon.vacation_booking.entities.Cart;
import com.solomon.vacation_booking.entities.CartItem;
import com.solomon.vacation_booking.entities.Customer;
import com.solomon.vacation_booking.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;


@Service
public class CheckoutServiceImpl implements  CheckoutService{

    private CustomerRepository customerRepository;

    private CartRepository cartRepository;


    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //check if the cart or cart items are null or empty
        if (purchase.getCart() == null || purchase.getCartItems().isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        // retrieve the cart info from dto
        Cart cart = purchase.getCart();

        //set cart status to "ordered"
        cart.setStatus(StatusType.ordered);

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        // populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        // populate cart with customer
//        cart.setCustomer(purchase.getCustomer());

        // populate customer with cart
//        Customer customer = purchase.getCustomer();
//        customer.add(cart);


        //save to the database
//        customerRepository.save(customer);
        cartRepository.save(cart);
        // return a response



            return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
