package com.example.geektrust.commands.parsers.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.contract.input.impl.BalanceInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BalanceInputParserTest {

    private BalanceInputParser balanceInputParserUnderTest;

    @BeforeEach
    void setUp() {
        balanceInputParserUnderTest = new BalanceInputParser();
    }

    @Test
    void testParseInput() {
        
        
        final BalanceInput result = balanceInputParserUnderTest.parseInput(new String[]{"BALANCE", "cardId", "0"});


        assertThat(result).isNotNull();
        assertThat(result).isInstanceOf(BalanceInput.class);
    }

    @Test
    void testCommandType() {
        assertThat(balanceInputParserUnderTest.commandType()).isEqualTo(CommandType.BALANCE);
    }
}
