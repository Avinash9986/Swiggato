package com.example.swiggato.transformer;

import com.example.swiggato.dto.request.RestarauntRequest;
import com.example.swiggato.dto.response.MenuResponse;
import com.example.swiggato.dto.response.RestarauntResponse;
import com.example.swiggato.model.Restraunt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestarauntTransformer {


    public static Restraunt RestarauntRequestoRestraunt(RestarauntRequest restarauntRequest){
        return Restraunt.builder()
                .name(restarauntRequest.getName())
                .contactNumber(restarauntRequest.getContactNumber())
                .location(restarauntRequest.getLocation())
                .restarauntCategory(restarauntRequest.getRestarauntCategory())
                .opened(true)
                .availableItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }

    public static RestarauntResponse RestarauntToRestarauntResponse(Restraunt restraunt) {

        List<MenuResponse> menu = restraunt.getAvailableItems().stream().map(foodItem -> FoodItemTransformer.FoodItemFoodResponse(foodItem)).collect(Collectors.toList());
        return RestarauntResponse.builder()
                .contactNumber(restraunt.getContactNumber())
                .name(restraunt.getName())
                .location(restraunt.getLocation())
                .opened(restraunt.isOpened())
                .menu(menu).build();
    }
}
