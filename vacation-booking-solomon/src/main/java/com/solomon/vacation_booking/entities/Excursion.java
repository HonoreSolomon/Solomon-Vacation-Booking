package com.solomon.vacation_booking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "excursion_title")
    private String excursion_title;

    @Column(name = "image_url")
    private String image_URL;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

//    @ManyToMany
//    @JoinTable(
//            name = "excursion_cartitem",
//            joinColumns = @JoinColumn(name = "excursion_id"),
//            inverseJoinColumns = @JoinColumn(name = "cart_item_id")
//    )
//    private Set<CartItem> cartItems;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "excursions")
    Set<CartItem> cartItems;

}
