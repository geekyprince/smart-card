package com.example.geektrust.service.impl;

import com.example.geektrust.db.CardRepository;
import com.example.geektrust.entity.Card;
import com.example.geektrust.service.CardService;
import org.springframework.stereotype.Service;

import static com.example.geektrust.config.ApplicationConfigs.DEFAULT_SERVICE_FEE;
import static com.example.geektrust.config.ApplicationConfigs.SERVICE_FEE_FACTOR;
import static java.util.Objects.requireNonNull;

@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void createCard(String cardId, Double balance) {
        Card card = new Card(cardId, balance);
        cardRepository.save(card);
    }

    public Double swipeAndReturnServiceFeeIfAny(Double fare, String cardId) {
        Card card = cardRepository.findById(cardId);
        requireNonNull(card, String.format("Card with id %s not found", cardId));
        Double serviceFee = rechargeIfRequiredAndReturnServiceFeeIfAny(fare, card);
        card.setBalance(card.getBalance() - fare);
        cardRepository.save(card);
        return serviceFee;
    }

    // TODO: This method can be made public if recharge functionality is required
    private Double rechargeIfRequiredAndReturnServiceFeeIfAny(Double fare, Card card) {
        if (card.getBalance() < fare) {
            Double topUpAmount = fare - card.getBalance();
            card.setBalance(card.getBalance() + topUpAmount);
            return fetchServiceFee(topUpAmount);
        }
        return DEFAULT_SERVICE_FEE;
    }

    private static double fetchServiceFee(Double topUpAmount) {
        return topUpAmount * SERVICE_FEE_FACTOR;
    }
}
