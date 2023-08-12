package com.example.geektrust.contract.input.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.contract.input.Input;
import com.example.geektrust.entity.enums.PassengerType;

public class CheckInInput implements Input {
    private final String cardId;
    private final PassengerType passengerType;
    private final String stationFrom;

    public CheckInInput(String cardId, PassengerType passengerType, String stationFrom) {
        this.cardId = cardId;
        this.passengerType = passengerType;
        this.stationFrom = stationFrom;
    }

    @Override
    public CommandType commandType() {
        return CommandType.CHECK_IN;
    }

    public String getCardId() {
        return cardId;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public String getStationFrom() {
        return stationFrom;
    }

}
