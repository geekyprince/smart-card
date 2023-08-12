package com.example.geektrust.service.impl;

import com.example.geektrust.db.JourneyRepository;
import com.example.geektrust.entity.Journey;
import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.entity.enums.Station;
import com.example.geektrust.service.PricingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JourneyServiceImplTest {

    @Mock
    private CardServiceImpl mockCardService;
    @Mock
    private JourneyRepository mockJourneyRepository;
    @Mock
    private PricingService mockPricingService;

    @InjectMocks
    private JourneyServiceImpl journeyServiceImplUnderTest;

    @Test
    void testCommute() {
        
        when(mockPricingService.getPrice(PassengerType.ADULT)).thenReturn(0.0);

        // Configure JourneyRepository.findAll(...).
        final List<Journey> journeys = Arrays.asList(Journey.builder()
                .createdAt(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .source(Station.CENTRAL)
                .destination(Station.CENTRAL)
                .cardId("cardId")
                .passengerType(PassengerType.ADULT)
                .ticketFee(0.0)
                .discountFee(0.0)
                .serviceFee(0.0)
                .build());
        when(mockJourneyRepository.findAll()).thenReturn(journeys);

        when(mockCardService.swipeAndReturnServiceFeeIfAny(0.0, "cardId")).thenReturn(0.0);

        // Configure JourneyRepository.save(...).
        final Journey journey = Journey.builder()
                .createdAt(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .source(Station.CENTRAL)
                .destination(Station.CENTRAL)
                .cardId("cardId")
                .passengerType(PassengerType.ADULT)
                .ticketFee(0.0)
                .discountFee(0.0)
                .serviceFee(0.0)
                .build();
        when(mockJourneyRepository.save(any(Journey.class))).thenReturn(journey);

        
        final Journey result = journeyServiceImplUnderTest.commute("cardId", PassengerType.ADULT, Station.CENTRAL,
                Station.CENTRAL);

        
    }

    @Test
    void testCommute_JourneyRepositoryFindAllReturnsNoItems() {
        
        when(mockPricingService.getPrice(PassengerType.ADULT)).thenReturn(0.0);
        when(mockJourneyRepository.findAll()).thenReturn(Collections.emptyList());
        when(mockCardService.swipeAndReturnServiceFeeIfAny(0.0, "cardId")).thenReturn(0.0);

        // Configure JourneyRepository.save(...).
        final Journey journey = Journey.builder()
                .createdAt(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .source(Station.CENTRAL)
                .destination(Station.CENTRAL)
                .cardId("cardId")
                .passengerType(PassengerType.ADULT)
                .ticketFee(0.0)
                .discountFee(0.0)
                .serviceFee(0.0)
                .build();
        when(mockJourneyRepository.save(any(Journey.class))).thenReturn(journey);

        
        final Journey result = journeyServiceImplUnderTest.commute("cardId", PassengerType.ADULT, Station.CENTRAL,
                Station.CENTRAL);

        
    }

    @Test
    void testFetchAllCommutedJourney() {
        
        // Configure JourneyRepository.findAll(...).
        final List<Journey> journeys = Arrays.asList(Journey.builder()
                .createdAt(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .source(Station.CENTRAL)
                .destination(Station.CENTRAL)
                .cardId("cardId")
                .passengerType(PassengerType.ADULT)
                .ticketFee(0.0)
                .discountFee(0.0)
                .serviceFee(0.0)
                .build());
        when(mockJourneyRepository.findAll()).thenReturn(journeys);

        
        final List<Journey> result = journeyServiceImplUnderTest.fetchAllCommutedJourney();

        
    }

    @Test
    void testFetchAllCommutedJourney_JourneyRepositoryReturnsNoItems() {
        
        when(mockJourneyRepository.findAll()).thenReturn(Collections.emptyList());

        
        final List<Journey> result = journeyServiceImplUnderTest.fetchAllCommutedJourney();

        
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
