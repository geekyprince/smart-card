package com.example.geektrust.config;

import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.exception.TicketPriceNotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketPricingConfigTest {

    private TicketPricingConfig ticketPricingConfigUnderTest;

    @BeforeEach
    void setUp() {
        ticketPricingConfigUnderTest = new TicketPricingConfig();
    }

    @Test
    void testGetTicketPriceForAdult() {
        
        final Double result = ticketPricingConfigUnderTest.getTicketPrice(PassengerType.ADULT);

        
        assertThat(result).isEqualTo(200.0);
    }

    @Test
    void testGetTicketPriceForSeniorCitizen() {
        
        final Double result = ticketPricingConfigUnderTest.getTicketPrice(PassengerType.SENIOR_CITIZEN);

        
        assertThat(result).isEqualTo(100.0);
    }

    @Test
    void testGetTicketPriceForKid() {
        
        final Double result = ticketPricingConfigUnderTest.getTicketPrice(PassengerType.KID);

        
        assertThat(result).isEqualTo(50.0);
    }

    @Test
    void testGetTicketPriceForInvalidPassengerType() {

        assertThrows(TicketPriceNotDefinedException.class, () -> {
            ticketPricingConfigUnderTest.getTicketPrice(PassengerType.SOME_RANDOM_TYPE);
        });
    }
}
