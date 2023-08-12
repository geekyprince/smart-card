package com.example.geektrust.entity;

import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.entity.enums.Station;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
public class Journey{

    @Builder.Default
    private final UUID id = UUID.randomUUID();
    @Builder.Default
    private final LocalDateTime createdAt = LocalDateTime.now();

    private Station source;
    private Station destination;
    private String cardId;
    private PassengerType passengerType;
    private Double ticketFee;
    private Double discountFee;
    private Double serviceFee;

    public Double getFare() {
        return ticketFee - discountFee;
    }
}
