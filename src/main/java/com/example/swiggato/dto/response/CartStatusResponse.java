package com.example.swiggato.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartStatusResponse {

    String cutomerName ;

    String customeraddress ;

    String customerMobile ;

    double cartTotal ;

    List<FoodResponse> foodList ;

    String restarauntName ;


}
