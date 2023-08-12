package com.example.geektrust.commands;

import com.example.geektrust.contract.input.impl.BalanceInput;
import com.example.geektrust.service.impl.CardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BalanceCommandTest {

    @Mock
    private CardServiceImpl mockCardService;

    private BalanceCommand balanceCommandUnderTest;

    @BeforeEach
    void setUp() {
        balanceCommandUnderTest = new BalanceCommand(mockCardService);
    }

    @Test
    void testExecute() {
        
        final BalanceInput input = new BalanceInput("cardId", 0.0);

        
        balanceCommandUnderTest.execute(input);

        
        verify(mockCardService).createCard("cardId", 0.0);
    }

    @Test
    void testCommandType() {
        assertThat(balanceCommandUnderTest.commandType()).isEqualTo(CommandType.BALANCE);
    }
}
