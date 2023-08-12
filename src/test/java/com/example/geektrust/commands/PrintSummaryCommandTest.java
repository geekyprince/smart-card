package com.example.geektrust.commands;

import com.example.geektrust.contract.input.impl.PrintSummaryInput;
import com.example.geektrust.service.SummaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PrintSummaryCommandTest {

    @Mock
    private SummaryService mockSummaryService;

    private PrintSummaryCommand printSummaryCommandUnderTest;

    @BeforeEach
    void setUp() {
        printSummaryCommandUnderTest = new PrintSummaryCommand(mockSummaryService);
    }

    @Test
    void testExecute() {
        
        final PrintSummaryInput input = new PrintSummaryInput(CommandType.BALANCE);

        
        printSummaryCommandUnderTest.execute(input);

        
        verify(mockSummaryService).printSummary();
    }

    @Test
    void testCommandType() {
        assertThat(printSummaryCommandUnderTest.commandType()).isEqualTo(CommandType.PRINT_SUMMARY);
    }
}
