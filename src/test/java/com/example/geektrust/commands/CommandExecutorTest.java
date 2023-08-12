package com.example.geektrust.commands;

import com.example.geektrust.contract.input.Input;
import com.example.geektrust.contract.input.impl.BalanceInput;
import com.example.geektrust.contract.input.impl.CheckInInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommandExecutorTest {

    @Mock
    private BalanceCommand mockBalanceCommand;
    @Mock
    private CheckInCommand mockCheckInCommand;
    @Mock
    private PrintSummaryCommand mockPrintSummaryCommand;

    private CommandExecutor commandExecutorUnderTest;

    @BeforeEach
    void setUp() {
        when(mockBalanceCommand.commandType()).thenReturn(CommandType.BALANCE);
        when(mockPrintSummaryCommand.commandType()).thenReturn(CommandType.PRINT_SUMMARY);
        commandExecutorUnderTest = new CommandExecutor(mockBalanceCommand, mockCheckInCommand, mockPrintSummaryCommand,
                Arrays.asList(mockBalanceCommand, mockPrintSummaryCommand));
    }

    @Test
    void testExecute() {
        final Input input = new BalanceInput("cardId", 0.0);
        commandExecutorUnderTest.execute(input);

        verify(mockBalanceCommand).execute(any(BalanceInput.class));

    }

    @Test
    void testExecuteWithInvalidCommand() {
        final Input input = new CheckInInput("cardId", null, null);

        // Assuming that the Checkin command type is not registered
        assertThrows(IllegalArgumentException.class, () -> {
            commandExecutorUnderTest.execute(input);
        });

    }
}
