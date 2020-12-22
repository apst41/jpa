package com.jpa.jpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidData extends RuntimeException {
    public InvalidData(String message){
        super(message);
    }
}
