package com.example.geektrust.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Card {
    private final String id;
    @Setter
    private Double balance;

    public Card(String id, Double balance) {
        this.id = id;
        this.balance = balance;
    }
}
