package com.example.geektrust.commands;

import com.example.geektrust.contract.input.impl.CheckInInput;
import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.entity.enums.Station;
import com.example.geektrust.service.JourneyService;
import com.example.geektrust.service.impl.CardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

class CheckInCommandTest {

    @Mock
    private JourneyService mockJourneyService;
    @Mock
    private CardServiceImpl mockCardService;

    private CheckInCommand checkInCommandUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        checkInCommandUnderTest = new CheckInCommand(mockJourneyService, mockCardService);
    }

    @Test
    void testExecute() {
        
        final CheckInInput input = new CheckInInput("cardId", PassengerType.ADULT, Station.CENTRAL.name());

        
        checkInCommandUnderTest.execute(input);

        
        verify(mockJourneyService).commute("cardId", PassengerType.ADULT, Station.CENTRAL, Station.AIRPORT);
    }

    @Test
    void testCommandType() {
        assertThat(checkInCommandUnderTest.commandType()).isEqualTo(CommandType.CHECK_IN);
    }
}
