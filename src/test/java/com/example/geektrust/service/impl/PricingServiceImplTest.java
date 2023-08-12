package com.example.geektrust.service.impl;

import com.example.geektrust.entity.enums.PassengerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PricingServiceImplTest {

    private PricingServiceImpl pricingServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        pricingServiceImplUnderTest = new PricingServiceImpl();
    }

    @Test
    void testGetPrice() {
        
        
        final Double result = pricingServiceImplUnderTest.getPrice(PassengerType.ADULT);

        
        assertThat(result).isEqualTo(200.0);
    }
}
