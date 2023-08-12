package com.example.geektrust.config;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationConfigsTest {

    @Test
    void testConfigVariables() {
        assertThat(ApplicationConfigs.DEFAULT_SERVICE_FEE).isEqualTo(0.0);
        assertThat(ApplicationConfigs.DISCOUNT_FACTOR_NORMAL_JOURNEY).isEqualTo(0.0);
        assertThat(ApplicationConfigs.DISCOUNT_FACTOR_RETURN_JOURNEY).isEqualTo(0.5);
        assertThat(ApplicationConfigs.FIRST_ARG).isEqualTo(0);
        assertThat(ApplicationConfigs.KID_TICKET_PRICE).isEqualTo(50.0);
        assertThat(ApplicationConfigs.MIN_ARGS).isEqualTo(1);
        assertThat(ApplicationConfigs.SENIOR_CITIZEN_TICKET_PRICE).isEqualTo(100.0);
        assertThat(ApplicationConfigs.SERVICE_FEE_FACTOR).isEqualTo(0.02);
    }
}
