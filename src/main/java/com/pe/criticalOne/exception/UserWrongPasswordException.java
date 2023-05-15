package com.pe.criticalOne.exception;

public class UserWrongPasswordException extends Exception{
    public UserWrongPasswordException(String message) {
        super(message);
    }
}
