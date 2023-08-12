package com.example.geektrust.service;

import com.example.geektrust.entity.enums.PassengerType;
import org.springframework.stereotype.Service;

@Service
public interface PricingService {
    Double getPrice(PassengerType passengerType);

}