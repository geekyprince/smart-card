package com.example.geektrust.exception;

public class InSufficientBalanceException extends RuntimeException{
    public InSufficientBalanceException(String message) {
        super(message);
    }
}