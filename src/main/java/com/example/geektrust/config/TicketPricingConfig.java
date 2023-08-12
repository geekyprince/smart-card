package com.example.geektrust.config;

import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.exception.TicketPriceNotDefinedException;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static com.example.geektrust.config.ApplicationConfigs.*;

@Component
public class TicketPricingConfig {
    private final HashMap<PassengerType, Double> ticketPricingConfig = new HashMap<PassengerType, Double>() {{
        put(PassengerType.ADULT, ADULT_TICKET_PRICE);
        put(PassengerType.SENIOR_CITIZEN, SENIOR_CITIZEN_TICKET_PRICE);
        put(PassengerType.KID, KID_TICKET_PRICE);
    }};

    public Double getTicketPrice(PassengerType passengerType) {
        if (ticketPricingConfig.containsKey(passengerType)) {
            return ticketPricingConfig.get(passengerType);
        }
        throw new TicketPriceNotDefinedException(String.format("Ticket price not defined for passenger type %s", passengerType.name()));
    }
}
