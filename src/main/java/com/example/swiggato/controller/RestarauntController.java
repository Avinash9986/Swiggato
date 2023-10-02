package com.example.swiggato.controller;

import com.example.swiggato.dto.request.MenuRequest;
import com.example.swiggato.dto.request.RestarauntRequest;
import com.example.swiggato.dto.response.RestarauntResponse;
import com.example.swiggato.service.RestarauntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Restaraunt")
public class RestarauntController {

    @Autowired
    RestarauntService restarauntService ;


    @PostMapping("/add")
    public ResponseEntity addRestaraunt(@RequestBody RestarauntRequest restarauntRequest){
        RestarauntResponse restarauntResponse = restarauntService.addRestaraunt(restarauntRequest) ;
        return new ResponseEntity<>(restarauntResponse, HttpStatus.CREATED) ;

    }

    @PutMapping("/update/status")
    public ResponseEntity changeOpenedStatus(@RequestParam int id ){
        String message = restarauntService.changeOpenedStatus(id) ;
        return new ResponseEntity<>(message,HttpStatus.ACCEPTED) ;
    }

    @PostMapping("/add/menu")
    public ResponseEntity addMenuToRestaraunt(@RequestBody MenuRequest menuRequest){
        RestarauntResponse restarauntResponse = restarauntService.addMenuToRestaraunt(menuRequest) ;
        return new ResponseEntity<>(restarauntResponse,HttpStatus.CREATED) ;
    }

    //get menu of a resturant


}
