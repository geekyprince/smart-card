package com.example.geektrust.service;

public interface CardService {
    void createCard(String cardId, Double balance);
    Double swipeAndReturnServiceFeeIfAny(Double fare, String cardId);
}
