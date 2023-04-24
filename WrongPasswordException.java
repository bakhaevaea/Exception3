package org.example;

public class WrongPasswordException extends Throwable {

    public WrongPasswordException(String message){
        super(message);
    }
}
