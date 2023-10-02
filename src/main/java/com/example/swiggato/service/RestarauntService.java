package com.example.swiggato.service;

import com.example.swiggato.dto.request.MenuRequest;
import com.example.swiggato.dto.request.RestarauntRequest;
import com.example.swiggato.dto.response.RestarauntResponse;
import com.example.swiggato.exception.RestarauntNotFoundException;
import com.example.swiggato.model.MenuItem;
import com.example.swiggato.model.Restraunt;
import com.example.swiggato.repository.RestarauntRepository;
import com.example.swiggato.transformer.FoodItemTransformer;
import com.example.swiggato.transformer.RestarauntTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestarauntService {

    @Autowired
    RestarauntRepository restarauntRepository ;
    public RestarauntResponse addRestaraunt(RestarauntRequest restarauntRequest) {
        Restraunt restraunt = RestarauntTransformer.RestarauntRequestoRestraunt(restarauntRequest) ;

        Restraunt savedRestaraunt = restarauntRepository.save(restraunt) ;

        return RestarauntTransformer.RestarauntToRestarauntResponse(savedRestaraunt) ;



    }

    public String changeOpenedStatus(int id) {

        Optional<Restraunt> restrauntOptional = restarauntRepository.findById(id) ;
        if (restrauntOptional.isEmpty()){
            throw new RestarauntNotFoundException("Restautant nit exist") ;
        }

        Restraunt restraunt = restrauntOptional.get() ;
        restraunt.setOpened(!restraunt.isOpened());
        restarauntRepository.save(restraunt) ;
        if (restraunt.isOpened()){
            return "Restaunrant is opened now!!!" ;
        }

        return "Resturant is not opemned" ;
    }

    public RestarauntResponse addMenuToRestaraunt(MenuRequest menuRequest) {
        Optional<Restraunt> restrauntOptional = restarauntRepository.findById(menuRequest.getResturantId()) ;
        if (restrauntOptional.isEmpty()){
            throw new RestarauntNotFoundException("Restautant nit exist") ;
        }

        Restraunt restraunt = restrauntOptional.get() ;

        MenuItem menuItem = FoodItemTransformer.FoodRequestToFoodItem(menuRequest) ;

        menuItem.setRestraunt(restraunt);

        restraunt.getAvailableItems().add(menuItem) ;

        Restraunt savedResturant = restarauntRepository.save(restraunt) ;

        return RestarauntTransformer.RestarauntToRestarauntResponse(savedResturant) ;
    }
}
