package com.example.geektrust.entity;

import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.entity.enums.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class JourneyTest {

    private Journey journeyUnderTest;

    @BeforeEach
    void setUp() {
        journeyUnderTest = new Journey(UUID.fromString("48663020-0be2-4159-9aa4-2b4d7dabc721"),
                LocalDateTime.of(2020, 1, 1, 0, 0, 0), Station.CENTRAL, Station.CENTRAL, "cardId", PassengerType.ADULT,
                0.0, 0.0, 0.0);
    }

    @Test
    void testGetFare() {
        assertThat(journeyUnderTest.getFare()).isEqualTo(0.0, within(0.0001));
    }

    @Test
    void testBuilder() {
        
        
        final Journey.JourneyBuilder result = Journey.builder();

        
    }
}
