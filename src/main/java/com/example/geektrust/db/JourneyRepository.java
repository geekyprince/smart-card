package com.example.geektrust.db;

import com.example.geektrust.entity.Journey;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface JourneyRepository extends Repository<Journey, UUID> {
}
