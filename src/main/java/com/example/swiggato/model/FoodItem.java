package com.example.swiggato.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "food_item")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    int requiredQuantity ;

    double totalCost ;

    @ManyToOne
    @JoinColumn
    Cart cart ;

    @ManyToOne
    @JoinColumn
    MenuItem menuItem ;

    @ManyToOne
    @JoinColumn
    OrderEntity order ;
}
