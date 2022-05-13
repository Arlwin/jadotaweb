package com.fajardo.jadotaweb.exceptions.user;

public class InvalidUserException extends Exception {

    public InvalidUserException(String errMessage){
        super(errMessage);
    }

    public InvalidUserException(String errMessage, Throwable rootErr){
        super(errMessage, rootErr);
    }

    public static InvalidUserException USER_DOES_NOT_EXIST(String id){
        return new InvalidUserException(String.format("Specified user with id %s does not exist", id));
    }
}
