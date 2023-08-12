package com.example.geektrust.contract.input.impl;

import com.example.geektrust.commands.CommandType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrintSummaryInputTest {

    private PrintSummaryInput printSummaryInputUnderTest;

    @BeforeEach
    void setUp() {
        printSummaryInputUnderTest = new PrintSummaryInput(CommandType.BALANCE);
    }

    @Test
    void testCommandType() {
        assertThat(printSummaryInputUnderTest.commandType()).isEqualTo(CommandType.PRINT_SUMMARY);
    }
}
