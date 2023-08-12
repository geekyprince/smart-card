package com.example.geektrust.exception;

public class InvalidCommandException extends RuntimeException{
    public InvalidCommandException(String message) {
        super(message);
    }
}