package com.example.swiggato.model;

import com.example.swiggato.Enum.FoodCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu_item")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id ;

    String dishName ;

    double price ;

    @Enumerated(EnumType.STRING)
    FoodCategory foodCategory ;

    boolean veg ;

    boolean available ;

    @ManyToOne
    @JoinColumn
    Restraunt restraunt ;

    @OneToMany(mappedBy = "menuItem",cascade = CascadeType.ALL)
    List<FoodItem> foodItems = new ArrayList<>() ;
}
