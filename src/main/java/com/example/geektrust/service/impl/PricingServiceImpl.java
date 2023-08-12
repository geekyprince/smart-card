package com.example.geektrust.service.impl;

import com.example.geektrust.config.TicketPricingConfig;
import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.service.PricingService;
import org.springframework.stereotype.Service;

@Service
public class PricingServiceImpl implements PricingService {
    private final TicketPricingConfig ticketPricingConfig = new TicketPricingConfig();

    @Override
    public Double getPrice(PassengerType passengerType) {
        return ticketPricingConfig.getTicketPrice(passengerType);
    }
}
