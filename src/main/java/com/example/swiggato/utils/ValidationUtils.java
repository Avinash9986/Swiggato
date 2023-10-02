package com.example.swiggato.utils;

import com.example.swiggato.model.Restraunt;
import com.example.swiggato.repository.RestarauntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidationUtils {
    @Autowired
    RestarauntRepository restarauntRepository ;

    public boolean validationRetuarant(int id){

        Optional<Restraunt> restrauntOptional = restarauntRepository.findById(id) ;
        return restrauntOptional.isPresent() ;
    }
}
