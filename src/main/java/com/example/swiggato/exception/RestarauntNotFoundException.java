package com.example.swiggato.exception;

public class RestarauntNotFoundException extends RuntimeException {
    public RestarauntNotFoundException(String message){
        super(message);
    }
}
