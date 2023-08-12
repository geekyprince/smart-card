package com.example.geektrust.db.impl;

import com.example.geektrust.db.CardRepository;
import com.example.geektrust.entity.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CardRepositoryImpl implements CardRepository {
    private final HashMap<String, Card> cards = new HashMap<>();

    @Override
    public Card save(Card card) {
        cards.put(card.getId(), card);
        return card;
    }

    @Override
    public Card findById(String id) {
        return cards.get(id);
    }

    @Override
    public List<Card> findAll() {
        return new ArrayList<>(cards.values());
    }
}
