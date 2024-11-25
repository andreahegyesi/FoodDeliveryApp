package org.example;
public class CannotCancelOrderException extends Exception{
    public CannotCancelOrderException(String message) {
        super(message);
    }

}