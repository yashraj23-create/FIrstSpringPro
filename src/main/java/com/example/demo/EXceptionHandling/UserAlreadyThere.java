package com.example.demo.EXceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyThere extends RuntimeException{
    public UserAlreadyThere(String message){
        super(message);
    }
}
