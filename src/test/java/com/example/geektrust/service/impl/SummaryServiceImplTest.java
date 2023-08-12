package com.example.geektrust.service.impl;

import com.example.geektrust.entity.Journey;
import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.entity.enums.Station;
import com.example.geektrust.service.JourneyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SummaryServiceImplTest {

    @Mock
    private JourneyService mockJourneyService;

    private SummaryServiceImpl summaryServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        summaryServiceImplUnderTest = new SummaryServiceImpl(mockJourneyService);
    }

    @Test
    void testPrintSummary() {
        
        // Configure JourneyService.fetchAllCommutedJourney(...).
        final List<Journey> journeys = Arrays.asList(Journey.builder()
                .source(Station.CENTRAL)
                .passengerType(PassengerType.ADULT)
                .discountFee(0.0)
                .serviceFee(0.0)
                .ticketFee(0.0)
                .build());
        when(mockJourneyService.fetchAllCommutedJourney()).thenReturn(journeys);

        summaryServiceImplUnderTest.printSummary();

    }

    @Test
    void testPrintSummary_JourneyServiceReturnsNoItems() {
        
        when(mockJourneyService.fetchAllCommutedJourney()).thenReturn(Collections.emptyList());
        
        summaryServiceImplUnderTest.printSummary();
    }
}
