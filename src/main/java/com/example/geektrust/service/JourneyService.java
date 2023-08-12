package com.example.geektrust.service;


import com.example.geektrust.entity.Journey;
import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.entity.enums.Station;

import java.util.List;

public interface JourneyService {
    Journey commute(String cardId, PassengerType passengerType, Station source, Station destination);
    List<Journey> fetchAllCommutedJourney();
}
