package com.example.geektrust.commands.parsers.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.contract.input.impl.PrintSummaryInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrintSummaryInputParserTest {

    private PrintSummaryInputParser printSummaryInputParserUnderTest;

    @BeforeEach
    void setUp() {
        printSummaryInputParserUnderTest = new PrintSummaryInputParser();
    }

    @Test
    void testParseInput() {
        
        
        final PrintSummaryInput result = printSummaryInputParserUnderTest.parseInput(new String[]{"PRINT_SUMMARY"});

        
        assertThat(result).isNotNull();
        assertThat(result).isInstanceOf(PrintSummaryInput.class);
    }

    @Test
    void testCommandType() {
        assertThat(printSummaryInputParserUnderTest.commandType()).isEqualTo(CommandType.PRINT_SUMMARY);
    }
}
