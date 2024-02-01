package com.sample.secondapp.exceptions;

public class UnknownPersonException extends Exception {

    public UnknownPersonException(){
        super();
    }

    public UnknownPersonException(String message){
        super(message);
    }
}
