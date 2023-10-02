package com.example.swiggato.dto.request;

import com.example.swiggato.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuRequest {

    int resturantId ;

    String dishName ;

    double price ;

    FoodCategory foodCategory ;

    boolean veg ;

    boolean available ;
}
