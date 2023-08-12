package com.example.geektrust.commands.parsers.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.contract.input.impl.CheckInInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheckInInputParserTest {

    private CheckInInputParser checkInInputParserUnderTest;

    @BeforeEach
    void setUp() {
        checkInInputParserUnderTest = new CheckInInputParser();
    }

    @Test
    void testParseInput() {
        final CheckInInput result = checkInInputParserUnderTest.parseInput(new String[]{"CHECK_IN", "passengerId", "ADULT", "stationId"});

        assertThat(result).isNotNull();
        assertThat(result).isInstanceOf(CheckInInput.class);
    }

    @Test
    void testCommandType() {
        assertThat(checkInInputParserUnderTest.commandType()).isEqualTo(CommandType.CHECK_IN);
    }
}
