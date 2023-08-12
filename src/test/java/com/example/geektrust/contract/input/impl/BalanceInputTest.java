package com.example.geektrust.contract.input.impl;

import com.example.geektrust.commands.CommandType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BalanceInputTest {

    private BalanceInput balanceInputUnderTest;

    @BeforeEach
    void setUp() {
        balanceInputUnderTest = new BalanceInput("cardId", 0.0);
    }

    @Test
    void testCommandType() {
        assertThat(balanceInputUnderTest.commandType()).isEqualTo(CommandType.BALANCE);
    }
}
