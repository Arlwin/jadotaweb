package com.fajardo.jadotaweb.exceptions.user;

public class InvalidUserException extends Exception {
    
    public InvalidUserException(String errMessage){
        super(errMessage);
    }

    public InvalidUserException(String errMessage, Throwable rootErr){
        super(errMessage, rootErr);
    }
}
