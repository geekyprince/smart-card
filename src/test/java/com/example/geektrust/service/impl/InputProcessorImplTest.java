package com.example.geektrust.service.impl;

import com.example.geektrust.commands.CommandExecutor;
import com.example.geektrust.contract.input.Input;
import com.example.geektrust.contract.input.impl.BalanceInput;
import com.example.geektrust.service.InputParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InputProcessorImplTest {

    @Mock
    private InputParser mockInputParser;
    @Mock
    private CommandExecutor mockCommandExecutor;

    @InjectMocks
    private InputProcessorImpl inputProcessorImplUnderTest;


    @Test
    void testProcessLine() {
        
        when(mockInputParser.parse("CHECK_IN MC1 ADULT CENTRAL")).thenReturn(new BalanceInput("cardId", 0.0));

        
        inputProcessorImplUnderTest.processLine("CHECK_IN MC1 ADULT CENTRAL");

        
        verify(mockCommandExecutor).execute(any(Input.class));
    }
}
