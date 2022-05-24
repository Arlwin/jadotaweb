package com.fajardo.jadotaweb.exceptions.user;

public class InvalidNewUserException extends Exception {
    
    public InvalidNewUserException(String errMessage){
        super(errMessage);
    }

    public InvalidNewUserException(String errMessage, Throwable rootErr){
        super(errMessage, rootErr);
    }

    public static InvalidNewUserException USER_ALREADY_EXISTS(String field, String value){
        return new InvalidNewUserException(String.format("%s %s is already taken.", field, value));
    }

    public static InvalidNewUserException USER_ALREADY_EXISTS(String field){
        return new InvalidNewUserException(String.format("%s is already taken.", field));
    }
}
