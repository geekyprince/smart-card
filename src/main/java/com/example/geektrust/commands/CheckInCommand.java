package com.example.geektrust.commands;

import com.example.geektrust.contract.input.impl.CheckInInput;
import com.example.geektrust.entity.enums.Station;
import com.example.geektrust.service.JourneyService;
import com.example.geektrust.service.impl.CardServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CheckInCommand implements Command<CheckInInput> {

    private final JourneyService journeyService;
    private final CardServiceImpl cardService;

    public CheckInCommand(JourneyService journeyService, CardServiceImpl cardService) {
        this.journeyService = journeyService;
        this.cardService = cardService;
    }

    @Override
    public void execute(CheckInInput input) {
        // TODO, since its assumed we have only 2 stations
        journeyService.commute(input.getCardId(), input.getPassengerType(), Station.valueOf(input.getStationFrom()), Station.valueOf(getDestination(input.getStationFrom())));
    }

    @Override
    public CommandType commandType() {
        return CommandType.CHECK_IN;
    }

    private String getDestination(String stationFrom) {
        return stationFrom.equals(Station.AIRPORT.name()) ? Station.CENTRAL.name() : Station.AIRPORT.name();
    }


}
