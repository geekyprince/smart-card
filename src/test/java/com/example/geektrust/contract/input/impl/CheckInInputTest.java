package com.example.geektrust.contract.input.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.entity.enums.PassengerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheckInInputTest {

    private CheckInInput checkInInputUnderTest;

    @BeforeEach
    void setUp() {
        checkInInputUnderTest = new CheckInInput("cardId", PassengerType.ADULT, "stationFrom");
    }

    @Test
    void testCommandType() {
        assertThat(checkInInputUnderTest.commandType()).isEqualTo(CommandType.CHECK_IN);
    }
}
