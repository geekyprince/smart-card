package com.example.geektrust.service.impl;

import com.example.geektrust.db.CardRepository;
import com.example.geektrust.entity.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardServiceImplTest {

    @Mock
    private CardRepository mockCardRepository;

    private CardServiceImpl cardServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        cardServiceImplUnderTest = new CardServiceImpl(mockCardRepository);
    }

    @Test
    void testCreateCard() {
        
        
        cardServiceImplUnderTest.createCard("cardId", 0.0);

        
        verify(mockCardRepository).save(any(Card.class));
    }

    @Test
    void testSwipeAndReturnServiceFeeIfAny() {
        
        when(mockCardRepository.findById("cardId")).thenReturn(new Card("cardId", 0.0));

        
        final Double result = cardServiceImplUnderTest.swipeAndReturnServiceFeeIfAny(0.0, "cardId");

        
        assertThat(result).isEqualTo(0.0, within(0.0001));
        verify(mockCardRepository).save(any(Card.class));
    }
}
