package com.example.geektrust.contract.input.impl;


import com.example.geektrust.commands.CommandType;
import com.example.geektrust.contract.input.Input;

public class BalanceInput implements Input {

    private final String cardId;
    private final Double amount;

    public BalanceInput(String cardId, Double amount) {
        this.cardId = cardId;
        this.amount = amount;
    }

    @Override
    public CommandType commandType() {
        return CommandType.BALANCE;
    }

    public String getCardId() {
        return cardId;
    }

    public Double getAmount() {
        return amount;
    }
}
