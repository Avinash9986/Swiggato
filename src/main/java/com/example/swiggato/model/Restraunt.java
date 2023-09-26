package com.example.swiggato.model;

import com.example.swiggato.Enum.RestarauntCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
@Table(name = "restraunt")
public class Restraunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id ;

    String name ;

    String location ;

    RestarauntCategory restarauntCategory ;

    @Size(min = 10,max = 10)
    String contactNumber ;

    boolean opened ;


    @OneToMany(mappedBy = "restraunt",cascade = CascadeType.ALL)
    List<FoodItem> availableItems = new ArrayList<>() ;

    @OneToMany(mappedBy = "restraunt",cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>() ;
}
