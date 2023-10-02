package com.example.swiggato.transformer;

import com.example.swiggato.dto.request.MenuRequest;
import com.example.swiggato.dto.response.MenuResponse;
import com.example.swiggato.model.MenuItem;

public class FoodItemTransformer {

    public static MenuItem FoodRequestToFoodItem(MenuRequest menuRequest){
        return MenuItem.builder()
                .dishName(menuRequest.getDishName())
                .price(menuRequest.getPrice())
                .foodCategory(menuRequest.getFoodCategory())
                .veg(menuRequest.isVeg())
                .available(menuRequest.isAvailable())
                .build();
    }
    public static MenuResponse FoodItemFoodResponse(MenuItem menuItem){
        return MenuResponse.builder()
                .dishName(menuItem.getDishName())
                .price(menuItem.getPrice())
                .veg(menuItem.isVeg())
                .category(menuItem.getFoodCategory())
                .build();
    }
}
