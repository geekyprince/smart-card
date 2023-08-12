package com.example.geektrust.db.impl;

import com.example.geektrust.db.JourneyRepository;
import com.example.geektrust.entity.Journey;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Component
public class JourneyRepositoryImpl implements JourneyRepository {
    private final HashMap<UUID, Journey> journeys = new HashMap<>();

    @Override
    public Journey save(Journey journey) {
        journeys.put(journey.getId(), journey);
        return journey;
    }

    @Override
    public List<Journey> findAll() {
        return new ArrayList<>(journeys.values());
    }

    @Override
    public Journey findById(UUID uuid) {
        return journeys.get(uuid);
    }
}
