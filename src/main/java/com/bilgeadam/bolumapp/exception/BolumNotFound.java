package com.bilgeadam.bolumapp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BolumNotFound extends RuntimeException{

    public BolumNotFound(String message) {
        super(message);
    }
}
