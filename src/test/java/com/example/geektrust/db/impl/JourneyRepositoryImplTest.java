package com.example.geektrust.db.impl;

import com.example.geektrust.entity.Journey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

class JourneyRepositoryImplTest {

    private JourneyRepositoryImpl journeyRepositoryImplUnderTest;

    @BeforeEach
    void setUp() {
        journeyRepositoryImplUnderTest = new JourneyRepositoryImpl();
    }

    @Test
    void testSave() {
        
        final Journey journey = Journey.builder()
                .id(UUID.fromString("bdd9a29a-3afd-4901-a18c-858af788b66a"))
                .build();

        
        final Journey result = journeyRepositoryImplUnderTest.save(journey);

        
    }

    @Test
    void testFindAll() {
        
        
        final List<Journey> result = journeyRepositoryImplUnderTest.findAll();

        
    }

    @Test
    void testFindById() {
        
        
        final Journey result = journeyRepositoryImplUnderTest.findById(
                UUID.fromString("343c8990-7204-47b8-9b28-8c1941001a63"));

        
    }
}
