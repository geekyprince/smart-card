package com.example.geektrust.service.impl;


import com.example.geektrust.db.JourneyRepository;
import com.example.geektrust.entity.Journey;
import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.entity.enums.Station;
import com.example.geektrust.service.JourneyService;
import com.example.geektrust.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static com.example.geektrust.config.ApplicationConfigs.*;

@Service
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    private CardServiceImpl cardService;
    @Autowired
    private JourneyRepository journeyRepository;
    @Autowired
    private PricingService pricingService;

    public Journey commute(String cardId, PassengerType passengerType, Station source, Station destination) {
        // TODO, since its assumed we have only 2 stations, Price is calculated based on passenger type only
        Double ticketPrice = pricingService.getPrice(passengerType);
        Double discountFactor = commuteDiscountFactor(cardId, destination);
        Double discountPrice = ticketPrice * discountFactor;
        Double fare = ticketPrice - discountPrice;
        Double serviceFee = cardService.swipeAndReturnServiceFeeIfAny(fare, cardId);

        Journey journey = Journey.builder()
                .cardId(cardId)
                .passengerType(passengerType)
                .source(source)
                .destination(destination)
                .ticketFee(ticketPrice)
                .discountFee(discountPrice)
                .serviceFee(serviceFee)
                .build();
        return journeyRepository.save(journey);
    }

    public List<Journey> fetchAllCommutedJourney() {
        return journeyRepository.findAll();
    }


    private Double commuteDiscountFactor(String cardId, Station destination) {
        List<Journey> journeyList = fetchAllCommutedJourney();
        Journey lastJourney = journeyList.stream()
                .filter(journey -> journey.getCardId().equals(cardId) && journey.getCreatedAt().isAfter(LocalDateTime.now().minusDays(1)))
                .sorted(Comparator.comparing(Journey::getCreatedAt).reversed()).findFirst().orElse(null);
        boolean isReturnJourney = lastJourney != null
                && Objects.equals(lastJourney.getDiscountFee(), DEFAULT_SERVICE_FEE)
                && lastJourney.getSource().equals(destination);
        return isReturnJourney ? DISCOUNT_FACTOR_RETURN_JOURNEY : DISCOUNT_FACTOR_NORMAL_JOURNEY;
    }

}
