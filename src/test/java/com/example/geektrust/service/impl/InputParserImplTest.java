package com.example.geektrust.service.impl;

import com.example.geektrust.contract.input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParserImplTest {

    private InputParserImpl inputParserImplUnderTest;

    @BeforeEach
    void setUp() {
        inputParserImplUnderTest = new InputParserImpl();
    }

    @Test
    void testParse() {
        
        
        final Input result = inputParserImplUnderTest.parse("CHECK_IN MC1 ADULT CENTRAL");

        
    }
}
