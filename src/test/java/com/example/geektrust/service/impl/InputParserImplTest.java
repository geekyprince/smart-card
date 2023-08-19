package com.example.geektrust.service.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.commands.parsers.impl.BalanceInputParser;
import com.example.geektrust.commands.parsers.impl.CheckInInputParser;
import com.example.geektrust.contract.input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InputParserImplTest {

    private InputParserImpl inputParserImplUnderTest;

    @Mock
    private BalanceInputParser mockBalanceInputParser;
    @Mock
    private CheckInInputParser mockCheckInInputParser;

    @BeforeEach
    void setUp() {
        when(mockBalanceInputParser.commandType()).thenReturn(CommandType.BALANCE);
        when(mockCheckInInputParser.commandType()).thenReturn(CommandType.CHECK_IN);
        inputParserImplUnderTest = new InputParserImpl(Arrays.asList(mockBalanceInputParser, mockCheckInInputParser));
    }

    @Test
    void testParse() {
        final Input result = inputParserImplUnderTest.parse("CHECK_IN MC1 ADULT CENTRAL");
    }
}
