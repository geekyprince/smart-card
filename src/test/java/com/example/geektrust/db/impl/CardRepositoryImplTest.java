package com.example.geektrust.db.impl;

import com.example.geektrust.entity.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CardRepositoryImplTest {

    private CardRepositoryImpl cardRepositoryImplUnderTest;

    @BeforeEach
    void setUp() {
        cardRepositoryImplUnderTest = new CardRepositoryImpl();
    }

    @Test
    void testSave() {
        
        final Card card = new Card("id", 0.0);

        
        final Card result = cardRepositoryImplUnderTest.save(card);

        
    }

    @Test
    void testFindById() {
        
        
        final Card result = cardRepositoryImplUnderTest.findById("id");

        
    }

    @Test
    void testFindAll() {
        
        
        final List<Card> result = cardRepositoryImplUnderTest.findAll();

        
    }
}
