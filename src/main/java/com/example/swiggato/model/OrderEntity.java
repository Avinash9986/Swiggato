package com.example.swiggato.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_entity")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id ;

    String orderId ;

    int orderTotal ;

    @CreationTimestamp
    Date orderTime ;

    @ManyToOne
    @JoinColumn
    Customer customer ;

    @ManyToOne
    @JoinColumn
    DeliveryPartner deliveryPartner ;

    @ManyToOne
    @JoinColumn
    Restraunt restraunt ;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    List<FoodItem> foodItems = new ArrayList<>() ;
}
