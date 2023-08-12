package com.example.geektrust.exception;

public class TicketPriceNotDefinedException extends RuntimeException{
    public TicketPriceNotDefinedException(String message) {
        super(message);
    }
}